package io.github.joxebus.challenge.repository


import io.github.joxebus.challenge.entity.Person
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
@Transactional
class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager

    Person save(Person newPerson) {
        if(newPerson.getId() == 0){
            entityManager.persist(newPerson)
        }
        newPerson
    }

    List<Person> list() {
        entityManager.createQuery("select p from Person p", Person.class).getResultList()
    }

    Person findById(int id) {
        entityManager.find(Person.class, id)
    }

    Person update(Person person) {
        Person dbPerson = entityManager.find(Person.class, person.getId())
        if(dbPerson != null){
            dbPerson.with {
                name = person.name
                lastName = person.lastName
                age = person.age
                phone = person.phone
            }
            entityManager.persist(dbPerson)
        }
        dbPerson
    }

    void delete(Person person) {
        Person dbPerson = entityManager.find(Person.class, person.getId())
        if(dbPerson != null){
            entityManager.remove(dbPerson)
        }
    }
}
