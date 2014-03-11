package es.kgp.activeMQTest.service;

import es.kgp.activeMQTest.model.MyMessage;

/**
 * Created by kgp on 11/01/2014.
 */
public interface MessageReceiverService {

    void processMessage(MyMessage message);

}
