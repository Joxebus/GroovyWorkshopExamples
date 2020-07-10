package io.github.joxebus.challenge


import io.github.joxebus.challenge.config.Bootstrap
import io.github.joxebus.challenge.service.PersonService
import spock.lang.Specification

class BootstrapSpec extends Specification {

    PersonService personService
    Bootstrap bootstrap

    def setup(){
        personService = Mock()
        bootstrap = new Bootstrap(
                personService: personService
        )
    }

    def "Test init method"(){
        when:
        bootstrap.init()

        then:
        1 * personService.findAll()
        5 * personService.create(_)
    }

}
