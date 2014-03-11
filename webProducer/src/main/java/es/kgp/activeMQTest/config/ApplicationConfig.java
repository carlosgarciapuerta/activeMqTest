package es.kgp.activeMQTest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by kgp on 11/01/2014.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"es.kgp.activeMQTest"})
@Import(JMSConfig.class)
public class ApplicationConfig {
}
