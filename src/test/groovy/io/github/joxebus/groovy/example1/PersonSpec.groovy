package io.github.joxebus.groovy.example1

import spock.lang.Specification

/**
 * This class has the same tests as the PersonTest
 */
class PersonSpec extends Specification {

    def "Verify Person java"(){
        given:
        io.github.joxebus.java.example1.Person person = new io.github.joxebus.java.example1.Person()

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
        Person person = new Person()

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
        io.github.joxebus.java.example1.Person person1 = new io.github.joxebus.java.example1.Person()
        io.github.joxebus.java.example1.Person person2 = new io.github.joxebus.java.example1.Person("Omar")
        io.github.joxebus.java.example1.Person person3 = new io.github.joxebus.java.example1.Person("Omar", "Bautista")
        io.github.joxebus.java.example1.Person person4 = new io.github.joxebus.java.example1.Person("Omar", "Bautista", 30)

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
        Person person1 = new Person()
        Person person2 = new Person("Omar")
        Person person3 = new Person("Omar", "Bautista")
        Person person4 = new Person("Omar", "Bautista", 30)

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
        Person person1 = new Person("Omar", "Bautista", 30)
        Person person2 = new Person("Omar", "Bautista", 30)
        io.github.joxebus.java.example1.Person person3 = new io.github.joxebus.java.example1.Person("Omar", "Bautista", 30)
        io.github.joxebus.java.example1.Person person4 = new io.github.joxebus.java.example1.Person("Omar", "Bautista", 30)

        expect:
        person1.hashCode() == person2.hashCode()

        and:
        person3.hashCode() == person3.hashCode()
    }

    def "Verify 2 persons of different class generate same hashCode"(){
        setup:
        Person person1 = new Person("Omar", "Bautista", 30)
        io.github.joxebus.java.example1.Person person2 = new io.github.joxebus.java.example1.Person("Omar", "Bautista", 30)

        expect: "The expected here is to modify the code to make the test pass"
        person1.hashCode() == person2.hashCode()
    }

}
