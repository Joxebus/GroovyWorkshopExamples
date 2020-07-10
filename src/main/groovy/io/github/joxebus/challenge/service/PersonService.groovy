package io.github.joxebus.challenge.service


import io.github.joxebus.challenge.repository.PersonRepository
import io.github.joxebus.challenge.entity.Person
import io.github.joxebus.challenge.utils.PersonValidator
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class)

    @Autowired
    private PersonRepository personRepository

    Person create(Person newPerson) {
        Person person
        use(PersonValidator){
            newPerson.validate()
            person = personRepository.save(newPerson)
            logger.debug("Person created: $person")
        }
        person
    }

    List<Person> findAll() {
        personRepository.findAll()
    }

    Person update(Person newPerson) {
        Person person
        use(PersonValidator){
            newPerson.validate()
            person = personRepository.findById(newPerson.getId()).orElseThrow(
                    () -> new IllegalArgumentException("Can't find person with id = ${newPerson.getId()}")
            )
            person.with {
                name = newPerson.name
                lastName = newPerson.lastName
                age = newPerson.age
                phone = newPerson.phone
            }
            person = personRepository.save(person)
            logger.debug("Person updated: {}", person)
        }
        person
    }

    void delete(int id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Can't delete person with id = ${id}")
        )
        logger.debug("Deleting person: $person")
        personRepository.delete(person)
    }

    Person findById(int id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Person not found")
        )
        logger.debug("Person found: {}", person)
        person
    }


}
