package io.github.joxebus.challenge.entity

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Canonical
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
    String name
    String lastName
    int age
    String phone

}
