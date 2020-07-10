package io.github.joxebus.challenge.service;

import io.github.joxebus.challenge.entity.Person;
import io.github.joxebus.challenge.repository.PersonRepository;
import io.github.joxebus.challenge.utils.PersonValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person newPerson) {
        PersonValidator.validate(newPerson);
        Person person = personRepository.save(newPerson);
        logger.debug("Person created: {}", person);
        return person;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person update(Person newPerson) {
        PersonValidator.validate(newPerson);
        Person person = personRepository.findById(newPerson.getId())
                .orElseThrow(() -> new IllegalArgumentException("Can't update person with id ="+newPerson.getId()));
        person.setName(newPerson.getName());
        person.setLastName(newPerson.getLastName());
        person.setAge(newPerson.getAge());
        person.setPhone(newPerson.getPhone());
        person = personRepository.save(person);
        logger.debug("Person updated: {}", person);
        return person;
    }

    public void delete(int id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can't delete person with id ="+id));
        logger.debug("Deleting person: {}", person);
        personRepository.delete(person);
    }

    public Person findById(int id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("There is no person with id ="+id));
        logger.debug("Person found: {}", person);
        return person;
    }


}
