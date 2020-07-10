package io.github.joxebus.challenge

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication (exclude = GroovyTemplateAutoConfiguration.class )
@RestController
class App {

    @GetMapping("/")
    String home(){
        "Welcome to Groovy Challenge"
    }

    static void main(String... args){
        SpringApplication.run(App.class, args)
    }
}
