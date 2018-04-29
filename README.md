# GroovyWorkshopExamples
Examples for Groovy Workshop

This repo has examples of the workshop which is aimed to people that want know about Groovy language,
since Groovy has similarity with languages like Python, Ruby, Perl and Smalltalk
people with previous knowledge on this and also Java will going to see similarities.

Groovy has been created to be companion with Java so most of the Java code is valid for Groovy.

If you are using IntelliJIDEa open the project and select the options:

- Use auto-import
- Create directories for empty content roots automatically
- Create separate module per source set

and finally

- Use default gradle wrapper

## Challenge - Make Java Application even Groovier

This challenge consist into convert most Java code as possible into Groovy code,
the example is a Spring Boot Application with no context.

When start the class **Bootstrap.java** loads some data into the **PersonDao.java** 

The idea is to create classes with the same name but with **groovy** extension and inside the
source folder `src/groovy` using the same packages.

Inside `src/main/resources` a file named postman_collection.json is placed, is a configuration
that can be load on postman and contains some examples for the requests.

When you finish execute the tests to verify your code still works as expected.


## Requirements

- Java 8
- Gradle 3.3
- Postman

## Run tests

For MacOS and Linux

`` ./gradlew test ``  

or for Windows

`` gradlew.bat test``
