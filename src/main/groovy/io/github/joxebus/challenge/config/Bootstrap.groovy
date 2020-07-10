package io.github.joxebus.challenge.config

import io.github.joxebus.challenge.entity.Person
import io.github.joxebus.challenge.service.PersonService
import groovy.json.JsonSlurper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class Bootstrap {

    Logger logger = LoggerFactory.getLogger(Bootstrap.class)

    @Value('${local.server.address:http://localhost}')
    String address
    @Value('${local.server.port:8080}')
    String port
    @Value('${spring.h2.console.path:/h2}')
    String h2Path

    @Autowired
    private PersonService personService

    @EventListener(ApplicationReadyEvent.class)
    void init() {
        logger.info("Loading initial information")

        if (!personService.findAll()) {
            try {
                // Use of JsonSlurper
                def jsonSlurper = new JsonSlurper()
                def personList = jsonSlurper.parse(getClass().getResource('/data.json'))
                // Iterate all the elements inside
                personList.each { p ->
                    Person person = new Person()
                    person.with {
                        name = p.name
                        lastName = p.lastName
                        age = p.age
                        phone = p.phone
                    }
                    personService.create(person) // here we can do some magic
                    logger.debug("Loading person: $person")
                }
            } catch (IOException | URISyntaxException e) {
                logger.error("Error trying to load data.txt", e)
            }
        }

        logger.info("Finish to load initial information")
        logger.info("Application running at: $address:$port")
        logger.info("H2 database manager at: $address:$port$h2Path")
    }
}
