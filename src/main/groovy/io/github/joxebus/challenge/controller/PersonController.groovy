package io.github.joxebus.challenge.controller


import io.github.joxebus.challenge.entity.Person
import io.github.joxebus.challenge.service.PersonService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/people")
class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class)

    @Autowired
    private PersonService personService

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    Person create(@RequestBody Person newPerson){
        personService.create(newPerson)
    }

    @PutMapping("/")
    Person update(@RequestBody Person newPerson){
        personService.update(newPerson)
    }

    @GetMapping(value = "/")
    List<Person> list(){
        personService.findAll()
    }

    @GetMapping(value = "/{id}")
    Person getById(@PathVariable(name = "id") int id){
        personService.findById(id)
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable(name = "id") int id){
        personService.delete(id)
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response)
            throws IOException {
        logger.error("The request contains illegal arguments: {}", e.getMessage())
        response.sendError(HttpStatus.BAD_REQUEST.value())
    }
}
