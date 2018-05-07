package com.nearsoft.challenge.config;

import com.nearsoft.challenge.entity.Person;
import com.nearsoft.challenge.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Configuration
public class Bootstrap {

    Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    private PersonService personService;

    @PostConstruct
    public void init() {
        logger.info("Loading initial information");

        if(personService.findAll() == null || personService.findAll().size() == 0) {
            try (Stream<String> stream = Files.lines(Paths
                    .get(getClass().getClassLoader().getResource("data.txt").toURI()))) {
                stream.forEach(line -> {
                    String data[] = line.split(",");
                    Person person = new Person();
                    person.setName(data[0].trim());
                    person.setLastName(data[1].trim());
                    person.setAge(Integer.parseInt(data[2].trim()));
                    person.setPhone(data[3].trim());
                    personService.create(person);
                    logger.info("Loading person: {}", person);
                });
            } catch (IOException | URISyntaxException e) {
                logger.error("Error trying to load data.txt", e);
            }
        }

        logger.info("Finish to load initial information");

    }
}
