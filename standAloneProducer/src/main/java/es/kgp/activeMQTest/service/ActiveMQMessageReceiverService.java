package es.kgp.activeMQTest.service;

import es.kgp.activeMQTest.model.MyMessage;
import org.springframework.stereotype.Component;

/**
 * Created by kgp on 11/01/2014.
 */
@Component
public class ActiveMQMessageReceiverService implements MessageReceiverService {

    @Override
    public void processMessage(MyMessage message){
        System.out.println("message = " + message.getSendTime());
        System.out.println("message.getText() = " + message.getText());
        System.out.println("****************************************");
    }

}
