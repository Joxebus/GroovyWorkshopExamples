package com.nearsoft.challenge

import com.nearsoft.challenge.dao.PersonDao
import com.nearsoft.challenge.entity.Person
import com.nearsoft.challenge.exception.PhoneFormatException
import com.nearsoft.challenge.service.PersonService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonServiceSpec extends Specification {

    PersonService personService
    PersonDao personDao

    @Shared
    Person person

    def setup(){
        personDao = Mock()
        personService = new PersonService(
                personDao: personDao
        )
        person = new Person()
        person.with {
            name = "Test"
            lastName = "Service"
            age = 20
        }
    }

    def "Person valid when create"(){
        when:
        personService.create(person)

        then:
        1 * personDao.save(person)
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
        thrown exception

        where:
        newName    |  newLastName   |   newAge  |   newPhone    | exception
        ''         | 'Something'    |   20      |   null        | RuntimeException
        'Something'| ''             |   20      |   null        | RuntimeException
        'Something'| 'Another Thing'|   0       |   null        | RuntimeException
        'Something'| 'Another Thing'|   20      |   '12387611'  | PhoneFormatException
    }

    def "Find a person by id"(){
        given:
        personDao = Stub()
        personService = new PersonService(
                personDao: personDao
        )


        and:
        personDao.findById(1) >> new Person([
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
