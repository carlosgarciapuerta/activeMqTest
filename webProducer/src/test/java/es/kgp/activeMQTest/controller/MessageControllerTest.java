package es.kgp.activeMQTest.controller;

import es.kgp.activeMQTest.config.ApplicationConfig;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by kgp on 11/01/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@Ignore
public class MessageControllerTest {

    @Autowired
    private MessageController messageController;

    @BeforeClass
    public static void setUp() throws NamingException {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL,"tcp://hostname:61616");
        javax.naming.Context ic = new InitialContext(props);
    }


    @Test
    public void should_not_throw_exception(){
        messageController.sendMessage("Test messange");
    }

}
