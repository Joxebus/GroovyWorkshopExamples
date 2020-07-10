# GroovyWorkshopExamples
[![Build Status](https://travis-ci.com/Joxebus/GroovyWorkshopExamples.svg?branch=example3)](https://travis-ci.com/Joxebus/GroovyWorkshopExamples)

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

### Example 3 - Java and Groovy working together

This branch contains examples using Groovy operators,
how to import Java Classes and use it inside Groovy code,
sort, reverse, with, find and findAll closures.

- Employee.java
- EmployeeService.groovy
- EmployeeSpec.groovy
- UseOperatorsSpec.groovy

## Requirements

- Java 8
- Gradle 5.6

## Run tests

For MacOS and Linux

`` ./gradlew test ``  

or for Windows

`` gradlew.bat test``
