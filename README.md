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

## Solution - Make Java Application even Groovier


Create classes with the same name but with **groovy** extension and inside the
source folder `src/groovy` use the same packages.

#### Change from Java to Groovy

Steps:

- Move classes to groovy folder
- Rename all the classes and change **.java** to **.groovy**
- Remove **public** declarations
- Change null checks for the same on Groovy Truth
- Remove **return** statements
- Change Json from glassfish dependency to Json Groovy support on Bootstrap class
- Change set sentences to **'with'** closure Groovy Style
- Use **ranges** to validate the **age**
- Instead of concat a String use GStrings (Groovy String Interpolation)
- Instead to call the method on PersonValidator use it as Category on PersonService

Extras:

- Since on bootstrap **'p'** is a map with the same name of properties of Person the sentence can be simplified with **'as'**
- JsonSlurper can be a single sentence
- PersonRepository can use the Groovy Truth istead of verify **id** and **null check**


Inside `src/main/resources` a file named **postman_collection.json** is placed, is a configuration
that can be load on postman and contains some examples for the requests.

When you finish execute the tests to verify your code still works as expected.

To see the results you can open in your browser the **index.html** created under.

```
build
|_reports
  |_tests
    |_test
      |_index.html
```



## Requirements

- Java 8
- Gradle 5.6
- Postman

## Run tests

For MacOS and Linux

`` ./gradlew test ``  

or for Windows

`` gradlew.bat test``

## Run Application

For MacOS and Linux

`` ./gradlew bootRun ``  

or for Windows

`` gradlew.bat bootRun``
