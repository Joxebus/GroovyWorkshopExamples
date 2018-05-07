package com.nearsoft.challenge.service;

import com.nearsoft.challenge.dao.PersonDao;
import com.nearsoft.challenge.entity.Person;
import com.nearsoft.challenge.exception.PhoneFormatException;
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
    private PersonDao personDao;

    public Person create(Person newPerson) {
        validate(newPerson);
        return personDao.save(newPerson);
    }

    public List<Person> findAll() {
        return personDao.list();
    }

    public Person update(Person newPerson) {
        validate(newPerson);
        if(newPerson.getId() < 1){
            throw new RuntimeException("Can't update person with id ="+newPerson.getId());
        }
        Person person = personDao.findById(newPerson.getId());
        person.setName(newPerson.getName());
        person.setLastName(newPerson.getLastName());
        person.setAge(newPerson.getAge());
        person.setPhone(newPerson.getPhone());
        return personDao.update(person);
    }

    public void delete(int id) {
        Person person = personDao.findById(id);
        if(person == null || person.getId() < 1){
            throw new RuntimeException("Can't delete person with id ="+id);
        }
        logger.debug("Deleting person: {}", person);
        personDao.delete(person);
    }

    public Person findById(int id) {
        Person person = personDao.findById(id);
        if(person == null){
            throw new RuntimeException("There is no person with id ="+id);
        }
        return person;
    }

    private void validate(Person person) {
        if(person == null){
            throw new RuntimeException("A null person is not valid.");
        }

        if(person.getName() == null || person.getName().isEmpty()){
            throw new RuntimeException("The person name is not valid.");
        }

        if(person.getLastName() == null || person.getLastName().isEmpty()){
            throw new RuntimeException("The person last name is not valid.");
        }

        if(person.getAge() < 1 || person.getAge() > 70 ){
            throw new RuntimeException("The person name is not valid.");
        }

        if(person.getPhone() != null && !Pattern.matches(PHONE_REGEX, person.getPhone())){
            throw new PhoneFormatException(String.format("Wrong format expected ###-###-####, but was: %s", person.getPhone()));
        }
    }


}
