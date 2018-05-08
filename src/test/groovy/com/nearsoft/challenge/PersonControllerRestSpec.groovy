package com.nearsoft.challenge

import com.nearsoft.challenge.entity.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerRestSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    def "/people/{id} should return an element"(){
        when:
        def entity = restTemplate.getForEntity("/people/1", Person)

        then:
        entity.statusCode    == HttpStatus.OK
        entity.body.id       == 1
        entity.body.name     == "Jorge"
        entity.body.lastName == "Valenzuela"
        entity.body.age      == 24
        entity.body.phone    == '662-862-1248'
    }

    def "/people should return a list"(){
        when:
        def entity = restTemplate.getForEntity("/people/", List)
        then:
        entity.statusCode       == HttpStatus.OK
        entity.body.size()      == 5
        entity.body*.id         == [1,2,3,4,5]
        entity.body*.name       == ['Jorge', 'Diana', 'Manuel', 'Omar', 'Eduardo']
        entity.body*.lastName   == ['Valenzuela', 'Hernandez', 'Sanchez', 'Bautista', 'Salazar']
        entity.body*.age        == [24, 35, 46, 30, 32]
        entity.body*.phone      == ['662-862-1248', '551-762-1237', '661-213-8642', '442-676-9872', '415-864-1238']
    }

    def "/people should save via post"(){
        given:
        Person person = new Person()
        person.with {
            name = "Krista"
            lastName = "Ojeda"
            age = 20
            phone = '662-121-1523'
        }

        HttpHeaders requestHeaders = new HttpHeaders()
        requestHeaders.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<Person> data = new HttpEntity<>(person, requestHeaders)

        when:
        def entity = restTemplate.postForEntity("/people/", data, Person)

        then:
        entity.statusCode     == HttpStatus.CREATED
        entity.body.id        >  5
        entity.body.name      == "Krista"
        entity.body.lastName  == "Ojeda"
        entity.body.age       == 20
        entity.body.phone     == '662-121-1523'
    }


    def "/people delete and get list"(){
        when:
        restTemplate.delete("/people/3")
        def entity = restTemplate.getForEntity("/people/", List)

        then:
        entity.statusCode       == HttpStatus.OK
        entity.body.size()      == 5
        entity.body*.id         == [1,2,4,5,6]
        entity.body*.name       == ['Jorge', 'Diana', 'Omar', 'Eduardo', 'Krista']
        entity.body*.lastName   == ['Valenzuela', 'Hernandez', 'Bautista', 'Salazar', 'Ojeda']
        entity.body*.age        == [24, 35, 30, 32, 20]
        entity.body*.phone      == ['662-862-1248', '551-762-1237', '442-676-9872', '415-864-1238', '662-121-1523']
    }

    def "/people update the first element"(){
        given:
        Person person = new Person()
        person.with {
            id = 1
            name = "Josue"
            lastName = "Fernandez"
            age = 39
            phone = '552-876-2341'
        }

        HttpHeaders requestHeaders = new HttpHeaders()
        requestHeaders.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<Person> data = new HttpEntity<>(person, requestHeaders)

        when:
        restTemplate.put("/people/", data)
        def entity = restTemplate.getForEntity("/people/1", Person)

        then:
        entity.statusCode     == HttpStatus.OK
        entity.body.id        == 1
        entity.body.name      == "Josue"
        entity.body.lastName  == "Fernandez"
        entity.body.age       == 39
        entity.body.phone     == '552-876-2341'
    }

    def "/people save should throw 400"() {
        given:
        Person person = new Person()
        person.with {
            name = newName
            lastName = newLastName
            age = newAge
            phone = newPhone
        }

        HttpHeaders requestHeaders = new HttpHeaders()
        requestHeaders.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<Person> data = new HttpEntity<>(person, requestHeaders)

        when:
        def entity = restTemplate.postForEntity("/people/", data, Person)

        then:
        entity.statusCode == HttpStatus.BAD_REQUEST

        where:
        newName    |  newLastName   |   newAge  |   newPhone
        ''         | 'Something'    |   20      |   null
        'Something'| ''             |   20      |   null
        'Something'| 'Another Thing'|   0       |   null
        'Something'| 'Another Thing'|   20      |   '12387611'
    }
}
