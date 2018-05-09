package com.nearsoft.challenge

import com.nearsoft.challenge.repository.PersonRepository
import com.nearsoft.challenge.entity.Person
import com.nearsoft.challenge.service.PersonService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonServiceSpec extends Specification {

    PersonService personService
    PersonRepository personRepository

    @Shared
    Person person

    def setup(){
        personRepository = Mock()
        personService = new PersonService(
                personRepository: personRepository
        )
        person = new Person()
        person.with {
            name = "Test"
            lastName = "Service"
            age = 20
        }
    }

    def "Person Service call repository save when entity has valid values"(){
        when:
        personService.create(person)

        then:
        1 * personRepository.save(person)
    }

    @Unroll("Testing invalid values name=#newName, lastName=#newLastName, age=#newAge, phone=#newPhone")
    def "Person with invalid fields throw exception"(){
        given:
        Person newPerson = new Person()
        newPerson.with {
            name = newName
            lastName = newLastName
            age = newAge
            phone = newPhone
        }

        when:
        Person person = personService.create(newPerson)

        then:
        thrown IllegalArgumentException

        where:
        newName    |  newLastName   |   newAge  |   newPhone
        ''         | 'Something'    |   20      |   null
        'Something'| ''             |   20      |   null
        'Something'| 'Another Thing'|   0       |   null
        'Something'| 'Another Thing'|   20      |   '12387611'
    }

    def "Find a person by id"(){
        given:
        personRepository = Stub()
        personService = new PersonService(
                personRepository: personRepository
        )


        and:
        personRepository.findById(1) >> new Person([
                id:1,
                name:"some",
                lastName:"thing",
                age: 30
        ])

        when:

        Person person = personService.findById(1)

        then:
        person.getId() == 1
        person.getName() == "some"
        person.getLastName() == "thing"
        person.getAge() == 30
    }

    def "Delete person throw exception"(){
        when:
        personService.delete(10)

        then:
        thrown RuntimeException
    }

}
