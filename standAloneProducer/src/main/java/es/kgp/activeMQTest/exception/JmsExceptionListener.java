package es.kgp.activeMQTest.exception;

import org.springframework.stereotype.Component;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

/**
 * Created by kgp on 12/01/2014.
 */
@Component("jmsExceptionListener")
public class JmsExceptionListener implements ExceptionListener {

    @Override
    public void onException(JMSException e) {
        e.printStackTrace();
    }

}
