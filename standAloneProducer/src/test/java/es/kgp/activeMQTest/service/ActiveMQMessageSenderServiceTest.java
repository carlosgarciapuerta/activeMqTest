package es.kgp.activeMQTest.service;

import es.kgp.activeMQTest.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kgp on 11/01/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ActiveMQMessageSenderServiceTest {

    @Autowired
    private ActiveMQMessageSenderService activeMQMessageSenderService;

    @Test
    public void should_not_throw_exception(){
        activeMQMessageSenderService.sendMessage("Test messange");
    }


}
