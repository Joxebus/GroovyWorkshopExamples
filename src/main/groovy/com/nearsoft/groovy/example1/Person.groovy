package com.nearsoft.groovy.example1

import groovy.transform.Canonical

/**
 * This class has the same fields as the java class
 * and also the same methods.
 */

@Canonical
class Person {

    String name
    String lastName
    int age

}
