package io.github.joxebus.java.example1;

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
        Person person = new Person();
        person.setName("Omar");
        person.setLastName("Bautista");
        person.setAge(30);

        assertEquals("Omar", person.getName());
        assertEquals("Bautista", person.getLastName());
        assertEquals(30, person.getAge());
    }

    @Test
    public void testPersonGroovy(){
        io.github.joxebus.groovy.example1.Person person = new io.github.joxebus.groovy.example1.Person();
        person.setName("Omar");
        person.setLastName("Bautista");
        person.setAge(30);

        assertEquals("Omar", person.getName());
        assertEquals("Bautista", person.getLastName());
        assertEquals(30, person.getAge());
    }

    @Test
    public void testFourConstructorsForJava(){
        Person person1 = new Person();
        Person person2 = new Person("Omar");
        Person person3 = new Person("Omar", "Bautista");
        Person person4 = new Person("Omar", "Bautista", 30);

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
        io.github.joxebus.groovy.example1.Person person1 = new io.github.joxebus.groovy.example1.Person();
        io.github.joxebus.groovy.example1.Person person2 = new io.github.joxebus.groovy.example1.Person("Omar");
        io.github.joxebus.groovy.example1.Person person3 = new io.github.joxebus.groovy.example1.Person("Omar", "Bautista");
        io.github.joxebus.groovy.example1.Person person4 = new io.github.joxebus.groovy.example1.Person("Omar", "Bautista", 30);

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
        io.github.joxebus.groovy.example1.Person person1 = new io.github.joxebus.groovy.example1.Person("Omar", "Bautista", 30);
        io.github.joxebus.groovy.example1.Person person2 = new io.github.joxebus.groovy.example1.Person("Omar", "Bautista", 30);
        Person person3 = new Person("Omar", "Bautista", 30);
        Person person4 = new Person("Omar", "Bautista", 30);

        assertEquals(person1.hashCode(), person2.hashCode());
        assertEquals(person3.hashCode(), person4.hashCode());
    }

    @Test
    public void testHasCodeForBothPersons(){
        io.github.joxebus.groovy.example1.Person person1 = new io.github.joxebus.groovy.example1.Person("Omar", "Bautista", 30);
        Person person2 = new Person("Omar", "Bautista", 30);

        assertEquals(person1.hashCode(), person2.hashCode());
    }


}
