package es.kgp.activeMQTest.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.jms.ConnectionFactory;

/**
 * Created by kgp on 10/01/2014.
 */
@Configuration
@ImportResource("classpath*:exception.properties")
public class JMSConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() throws Exception {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setCache(true);
        jndiObjectFactoryBean.setExpectedType(ActiveMQConnectionFactory.class);
        jndiObjectFactoryBean.setLookupOnStartup(true);
        jndiObjectFactoryBean.setProxyInterface(ConnectionFactory.class);
        jndiObjectFactoryBean.setResourceRef(true);
        return (ActiveMQConnectionFactory) jndiObjectFactoryBean.getObject();
    }

    @Bean
    public ActiveMQQueue activeMQQueue() throws Exception {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setCache(true);
        jndiObjectFactoryBean.setExpectedType(ActiveMQQueue.class);
        jndiObjectFactoryBean.setLookupOnStartup(true);
        jndiObjectFactoryBean.setProxyInterface(ConnectionFactory.class);
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setJndiName("exception/activeMQTestQueue");
        return (ActiveMQQueue) jndiObjectFactoryBean.getObject();
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() throws Exception {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(activeMQConnectionFactory());
        connectionFactory.setSessionCacheSize(10);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() throws Exception {
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory());
        jmsTemplate.setDefaultDestination(activeMQQueue());
        return jmsTemplate;
    }

}
