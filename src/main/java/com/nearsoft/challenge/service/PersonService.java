package com.nearsoft.challenge.service;

import com.nearsoft.challenge.repository.PersonRepository;
import com.nearsoft.challenge.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private static final String PHONE_REGEX = "(\\d{3})-(\\d{3})-(\\d{4})";

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person newPerson) {
        validate(newPerson);
        return personRepository.save(newPerson);
    }

    public List<Person> findAll() {
        return personRepository.list();
    }

    public Person update(Person newPerson) {
        validate(newPerson);
        if(newPerson.getId() < 1){
            throw new RuntimeException("Can't update person with id ="+newPerson.getId());
        }
        Person person = personRepository.findById(newPerson.getId());
        person.setName(newPerson.getName());
        person.setLastName(newPerson.getLastName());
        person.setAge(newPerson.getAge());
        person.setPhone(newPerson.getPhone());
        return personRepository.update(person);
    }

    public void delete(int id) {
        Person person = personRepository.findById(id);
        if(person == null || person.getId() < 1){
            throw new IllegalArgumentException("Can't delete person with id ="+id);
        }
        logger.debug("Deleting person: {}", person);
        personRepository.delete(person);
    }

    public Person findById(int id) {
        Person person = personRepository.findById(id);
        if(person == null){
            throw new IllegalArgumentException("There is no person with id ="+id);
        }
        return person;
    }

    private void validate(Person person) {
        if(person == null){
            throw new IllegalArgumentException("A null person is not valid.");
        }

        if(person.getName() == null || person.getName().isEmpty()){
            throw new IllegalArgumentException("The person name is not valid.");
        }

        if(person.getLastName() == null || person.getLastName().isEmpty()){
            throw new IllegalArgumentException("The person last name is not valid.");
        }

        if(person.getAge() < 1 || person.getAge() > 70 ){
            throw new IllegalArgumentException("The person name is not valid.");
        }

        if(person.getPhone() != null && !Pattern.matches(PHONE_REGEX, person.getPhone())){
            throw new IllegalArgumentException(String.format("Wrong format expected ###-###-####, but was: %s", person.getPhone()));
        }
    }


}
