package com.nearsoft.challenge.dao;

import com.nearsoft.challenge.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private static List<Person> people = new ArrayList<>();
    private static int nextId = 1;

    public Person save(Person newPerson) {
        if(newPerson.getId() == 0){
            newPerson.setId(nextId++);
        }
        people.add(newPerson);
        return newPerson;
    }

    public List<Person> list() {
        return people;
    }

    public Person findById(int id) {
        Person person = null;
        for(Person p : people){
            if(p.getId() == id){
                person = p;
                break;
            }
        }
        return person;
    }

    public Person update(Person person) {
        int index = people.indexOf(person);
        if(index > -1){
            people.add(index, person);
        }
        return person;
    }

    public void delete(Person person) {
        int index = people.indexOf(person);
        if(index > -1){
            people.remove(index);
        }
    }
}
