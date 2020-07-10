package io.github.joxebus.challenge

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableAutoConfiguration
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
