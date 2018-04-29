package com.nearsoft.java.example1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * This class has the same tests as the PersonSpec
 */
public class PersonTest {

    @Test
    public void testPersonJava(){
        // Is not necessary  to use the whole package since this class is in the same.
        com.nearsoft.java.example1.Person person = new com.nearsoft.java.example1.Person();
        person.setName("Omar");
        person.setLastName("Bautista");
        person.setAge(30);

        assertEquals("Omar", person.getName());
        assertEquals("Bautista", person.getLastName());
        assertEquals(30, person.getAge());
    }

    @Test
    public void testPersonGroovy(){
        com.nearsoft.groovy.example1.Person person = new com.nearsoft.groovy.example1.Person();
        person.setName("Omar");
        person.setLastName("Bautista");
        person.setAge(30);

        assertEquals("Omar", person.getName());
        assertEquals("Bautista", person.getLastName());
        assertEquals(30, person.getAge());
    }

    @Test
    public void testFourConstructorsForJava(){
        com.nearsoft.java.example1.Person person1 = new com.nearsoft.java.example1.Person();
        com.nearsoft.java.example1.Person person2 = new com.nearsoft.java.example1.Person("Omar");
        com.nearsoft.java.example1.Person person3 = new com.nearsoft.java.example1.Person("Omar", "Bautista");
        com.nearsoft.java.example1.Person person4 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30);

        // person1
        assertNull(person1.getName());
        assertNull(person1.getLastName());
        assertEquals(0, person1.getAge());

        // person2
        assertEquals("Omar", person2.getName());
        assertNull(person2.getLastName());
        assertEquals(0, person2.getAge());

        // person3
        assertEquals("Omar", person3.getName());
        assertEquals("Bautista",person3.getLastName());
        assertEquals(0, person3.getAge());

        // person4
        assertEquals("Omar", person4.getName());
        assertEquals("Bautista",person4.getLastName());
        assertEquals(30, person4.getAge());
    }

    @Test
    public void testFourConstructorsForGroovy(){
        com.nearsoft.groovy.example1.Person person1 = new com.nearsoft.groovy.example1.Person();
        com.nearsoft.groovy.example1.Person person2 = new com.nearsoft.groovy.example1.Person("Omar");
        com.nearsoft.groovy.example1.Person person3 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista");
        com.nearsoft.groovy.example1.Person person4 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30);

        // person1
        assertNull(person1.getName());
        assertNull(person1.getLastName());
        assertEquals(0, person1.getAge());

        // person2
        assertEquals("Omar", person2.getName());
        assertNull(person2.getLastName());
        assertEquals(0, person2.getAge());

        // person3
        assertEquals("Omar", person3.getName());
        assertEquals("Bautista",person3.getLastName());
        assertEquals(0, person3.getAge());

        // person4
        assertEquals("Omar", person4.getName());
        assertEquals("Bautista",person4.getLastName());
        assertEquals(30, person4.getAge());
    }

    @Test
    public void testHashCodeForBothPersons(){
        com.nearsoft.groovy.example1.Person person1 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30);
        com.nearsoft.groovy.example1.Person person2 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30);
        com.nearsoft.java.example1.Person person3 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30);
        com.nearsoft.java.example1.Person person4 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30);

        assertEquals(person1.hashCode(), person2.hashCode());
        assertEquals(person3.hashCode(), person4.hashCode());
    }

    @Test
    public void testHasCodeForBothPersons(){
        com.nearsoft.groovy.example1.Person person1 = new com.nearsoft.groovy.example1.Person("Omar", "Bautista", 30);
        com.nearsoft.java.example1.Person person2 = new com.nearsoft.java.example1.Person("Omar", "Bautista", 30);

        assertEquals(person1.hashCode(), person2.hashCode());
    }


}
