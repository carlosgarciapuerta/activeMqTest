package es.kgp.activeMQTest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by kgp on 11/01/2014.
 */
@Configuration
@ComponentScan(basePackages = {"es.kgp.activeMQTest"})
@Import(JMSConfig.class)
public class ApplicationConfig {
}
