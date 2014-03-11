package es.kgp.activeMQTest.controller;

import es.kgp.activeMQTest.service.MessageSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kgp on 11/01/2014.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    private final static Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageSenderService messageSenderService;

    public void sendMessage(@RequestBody String text){
        logger.debug("Text: " + text + ", received");
        messageSenderService.sendMessage(text);
    }


}
