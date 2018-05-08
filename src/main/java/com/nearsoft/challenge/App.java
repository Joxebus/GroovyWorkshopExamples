package com.nearsoft.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Value("${local.server.address:http://localhost}")
    private String address;
    @Value("${local.server.port:8080}")
    private String port;
    @Value("${spring.h2.console.path:/h2}")
    private String h2Path;

    @GetMapping("/")
    public String home(){
        return "Welcome to Groovy Challenge";
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        logger.debug("Application running at: {}:{}", address, port);
        logger.debug("H2 database manager at: {}:{}{}", address, port, h2Path);
    }

    public static void main(String... args){
        SpringApplication.run(App.class, args);
    }
}
