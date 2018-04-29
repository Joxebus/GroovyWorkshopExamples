package com.nearsoft.challenge

import com.nearsoft.challenge.controller.PersonController
import com.nearsoft.challenge.entity.Person
import com.nearsoft.challenge.service.PersonService
import spock.lang.Shared
import spock.lang.Specification

class PersonControllerSpec extends Specification {

    PersonController personController
    PersonService personService

    @Shared Person person

    def setup(){
        personService = Mock()
        personController = new PersonController(
                personService: personService
        )
        person = new Person([
                name: "Test",
                lastName: "Interaction",
                age: 20
        ])

    }

    def "Test PersonService create method is called"(){
        when:
        personController.create(person)

        then:
        1 * personService.create(person)
    }

    def "Test PersonService list method is called"(){
        when:
        personController.list()

        then:
        1 * personService.findAll()
    }

    def "Test PersonService find by id is called"(){
        when:
        personController.getById(1)
        personController.getById(2)

        then:
        1 * personService.findById(1)
        1 * personService.findById(2)
    }

    def "Test PersonService update method is called"(){
        given:

        when:
        personController.update(person)

        then:
        1 * personService.update(person)
    }

    def "Test PersonService delete method is called"(){
        when:
        personController.create(person)

        and:
        personController.delete(person.id)

        then:
        1 * personService.create(person)
        1 * personService.delete(person.id)
    }



}
