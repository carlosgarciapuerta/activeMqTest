package es.kgp.activeMQTest.service;

import es.kgp.activeMQTest.model.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Created by kgp on 11/01/2014.
 */
@Component
public class ActiveMQMessageListener implements MessageListener{

    @Autowired
    private ActiveMQMessageReceiverService activeMQMessageReceiverService;

    @Override
    public void onMessage(Message message) {
        try {
            MyMessage mqMessage = (MyMessage) ((ObjectMessage) message).getObject();
            activeMQMessageReceiverService.processMessage(mqMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
