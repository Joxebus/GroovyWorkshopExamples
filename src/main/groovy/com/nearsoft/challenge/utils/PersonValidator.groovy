package com.nearsoft.challenge.utils

import com.nearsoft.challenge.entity.Person


class PersonValidator {

    private static final String PHONE_REGEX = /(\d{3})-(\d{3})-(\d{4})/

    static void validate(Person person) {
        if(!person){
            throw new IllegalArgumentException("A null person is not valid.")
        }

        validateName(person.getName())
        validateLastName(person.getLastName())
        validateAge(person.getAge())
        validatePhone(person.getPhone())
    }

    private static void validateName(String name) {
        if(!name){
            throw new IllegalArgumentException("The person name is not valid.")
        }
    }

    private static void validateLastName(String lastName) {
        if(!lastName){
            throw new IllegalArgumentException("The person last name is not valid.")
        }
    }

    private static void validateAge(int age) {
        if(!(age in 1..69)){
            throw new IllegalArgumentException("The person age is not valid.")
        }
    }

    private static void validatePhone(String phone) {
        if(phone && !(phone =~ PHONE_REGEX)){
            throw new IllegalArgumentException("Wrong format expected ###-###-####, but was: $phone")
        }
    }
}
