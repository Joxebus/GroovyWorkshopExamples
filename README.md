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

### Example 1 - Differences and similarities between Groovy and Java

This example contains 2 classes:

- **Person.groovy**
- **Person.java**

Both has the same fields and methods on their own style.          

Also this example contains 2 classes one that test with JUnit and the other with Spock.
  
- **PersonSpec.groovy** // spock test class
- **PersonTest.java**   // junit test class

Both classes contains the same tests but in their own style.


## Requirements

- Java 8
- Gradle 5.6

## Run tests

For MacOS and Linux

`` ./gradlew test ``  

or for Windows

`` gradlew.bat test``
