package es.kgp.activeMQTest.service;


import es.kgp.activeMQTest.model.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;

/**
 * Created by kgp on 11/01/2014.
 */
@Service
public class ActiveMQMessageSenderService implements MessageSenderService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(final String text){
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(new MyMessage(text, new Date()));
            }
        });
    }


}
