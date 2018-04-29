package com.nearsoft.groovy.example1

import spock.lang.Specification

/**
 * This class has the same tests as the PersonTest
 */
class PersonSpec extends Specification {

    def "Verify Person java"(){
        given:
        com.nearsoft.java.example1.Person person = new com.nearsoft.java.example1.Person()

        when:
        person.setName("Omar")
        person.setLastName("Bautista")
        person.setAge(30)

        then:
        person.getAge() == 30
        person.getLastName() == "Bautista"
        person.getName() == "Omar"
    }

    def "Verify Person groovy"(){
        given:
        // Is not necessary  to use the whole package since this class is in the same.
        com.nearsoft.groovy.example1.Person person = new com.nearsoft.groovy.example1.Person()

        when:
        person.setName("Omar")
        person.setLastName("Bautista")
        person.setAge(30)

        then:
        person.getAge() == 30
        person.getLastName() == "Bautista"
        person.getName() == "Omar"
    }

    def "Verify the 4 constructors for Java"(){
        setup:
        com.nearsoft.java.example1.Person person1 = new com.nearsoft.java.example1.Person()
        com.nearsoft.java.example1.Person person2 = new com.nearsoft.java.example1.Person("Omar")
        com.nearsoft.java.example1.Person person3 = new com.nearsoft.java.example1.Person("Omar", "Bautista")
        com.nearsoft.java.example1.Person person4 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30)

        expect:
        person1.getName() == null
        person1.getLastName() == null
        person1.getAge() == 0

        and:
        person2.getName() == "Omar"
        person2.getLastName() == null
        person2.getAge() == 0

        and:
        person3.getName() == "Omar"
        person3.getLastName() == "Bautista"
        person3.getAge() == 0

        and:
        person4.getName() == "Omar"
        person4.getLastName() == "Bautista"
        person4.getAge() == 30
    }

    def "Verify the 4 constructors for Groovy"(){
        setup:
        com.nearsoft.groovy.example1.Person person1 = new com.nearsoft.groovy.example1.Person()
        com.nearsoft.groovy.example1.Person person2 = new com.nearsoft.groovy.example1.Person("Omar")
        com.nearsoft.groovy.example1.Person person3 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista")
        com.nearsoft.groovy.example1.Person person4 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30)

        expect:
        person1.getName() == null
        person1.getLastName() == null
        person1.getAge() == 0

        and:
        person2.getName() == "Omar"
        person2.getLastName() == null
        person2.getAge() == 0

        and:
        person3.getName() == "Omar"
        person3.getLastName() == "Bautista"
        person3.getAge() == 0

        and:
        person4.getName() == "Omar"
        person4.getLastName() == "Bautista"
        person4.getAge() == 30
    }

    def "Verify 2 persons can generate the same hashCode"(){
        setup:
        com.nearsoft.groovy.example1.Person person1 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30)
        com.nearsoft.groovy.example1.Person person2 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30)
        com.nearsoft.java.example1.Person person3 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30)
        com.nearsoft.java.example1.Person person4 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30)

        expect:
        person1.hashCode() == person2.hashCode()

        and:
        person3.hashCode() == person3.hashCode()
    }

    def "Verify 2 persons of different class generate same hashCode"(){
        setup:
        com.nearsoft.groovy.example1.Person person1 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30)
        com.nearsoft.java.example1.Person person2 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30)

        expect: "The expected here is to modify the code to make the test pass"
        person1.hashCode() == person2.hashCode()
    }

}
