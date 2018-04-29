package com.nearsoft.groovy.example3

import com.nearsoft.java.example3.Employee
import spock.lang.Specification
import spock.lang.Unroll

class UseOperatorsSpec extends Specification {

    def "The with closure"(){
        given:
        Date date = new Date()
        Employee employee = new Employee()

        when: "Using with closure on Java class to call setters"
        employee.with {
            employeeId = "007"
            name = "James Bond"
            startDate = date
            active = true
        }

        then:
        employee.getStartDate() == date
        employee.employeeId == "007"      // same as employee.getEmployeeId
        employee["name"] == "James Bond"  // same as employee.getName()
        employee.getAt("active") == true  // same as employee.isActive()
    }

    def "The nullsafe operator"(){
        given:
        Employee employee = new Employee()

        when: "Call a method from a null name"
        employee.getName()?.split("") // should not throw an exception

        then:
        noExceptionThrown()
    }



    def "The Spread dot operator"(){
        given:
        List employees = []
        def employeeService = new EmployeeService()

        when: "add 3 employees using operator overloading"
        employees.add(employeeService.createEmployee("001", "Diana", new Date(), true)) // parenthesis are optional
        employees += employeeService.createEmployee("002", "Alexa", new Date(), false) // same as use employees.add( someElement )
        employees << employeeService.createEmployee("003", "Javier", new Date(), true) // same as use employees.add( someElement )

        then:
        employees.size() == 3
        employees*.name == ["Diana", "Alexa", "Javier"]
        employees*.active == [true, false, true]
        employees*.employeeId == ["001","002","003"]
    }

    def "The Spread dot operator for parameters"(){
        given:
        def employeeService = new EmployeeService()
        def params = ["007", "James Bond", new Date(), true]

        when:
        def employee = employeeService.createEmployee(*params)

        then:
        employee.getName() == "James Bond"
        employee.getEmployeeId() == "007"
        employee.getStartDate() == params[2]
        employee.isActive() // don't need to compare with == true cause is a boolean
    }

    def "The elvis operator"(){
        given:
        def employee = new Employee()

        when:
        String employeeId = employee.getName() ?: 'UNDEFINED'

        then:
        employeeId == 'UNDEFINED'

    }

    @Unroll("Testing with #first and #second expecting #expectedResult")
    def "The spaceship operator"(){
        setup:
        int result = first <=> second

        expect:
        result == expectedResult

        where: "This block of code can be used to define a table to test different values"
        first | second | expectedResult
        5     | 4      | 1
        4     | 4      | 0
        3     | 4      | -1
    }
}
