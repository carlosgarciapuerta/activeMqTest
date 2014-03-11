package es.kgp.activeMQTest.config;

import es.kgp.activeMQTest.service.ActiveMQMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.AbstractJmsListeningContainer;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ExceptionListener;
import javax.jms.Session;

/**
 * Created by kgp on 10/01/2014.
 */
@Configuration
@PropertySource("classpath:/jms.properties")
public class JMSConfig {

    @Autowired
    private Environment env;

    @Autowired
    private ActiveMQMessageListener mqMessageListener;

    @Autowired
    private ExceptionListener jmsExceptionListener;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() throws Exception {
        return new ActiveMQConnectionFactory(env.getProperty("activeMq.broker.url"));
    }

    @Bean
    public ActiveMQQueue activeMQQueue() throws Exception {
        return new ActiveMQQueue(env.getProperty("queue.name"));
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() throws Exception {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(activeMQConnectionFactory());
        connectionFactory.setSessionCacheSize(Integer.valueOf(env.getProperty("session.cache.size")));
        connectionFactory.setExceptionListener(jmsExceptionListener);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() throws Exception {
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory());
        jmsTemplate.setDefaultDestination(activeMQQueue());
        return jmsTemplate;
    }

    @Bean
    public AbstractJmsListeningContainer messageListenerContainer() throws Exception {
        DefaultMessageListenerContainer listenerContainer = new DefaultMessageListenerContainer();
        listenerContainer.setConnectionFactory(cachingConnectionFactory());
        listenerContainer.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        listenerContainer.setDestination(activeMQQueue());
        listenerContainer.setMessageListener(mqMessageListener);
        return listenerContainer;
    }

}
