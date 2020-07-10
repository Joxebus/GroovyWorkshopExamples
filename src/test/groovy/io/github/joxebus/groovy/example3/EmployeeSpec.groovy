package io.github.joxebus.groovy.example3

import io.github.joxebus.java.example3.Employee
import spock.lang.Shared
import spock.lang.Specification

class EmployeeSpec extends Specification {

    @Shared EmployeeService employeeService

    /**
     * This method is the same as the @BeforeClass of JUnit
     */
    def setupSpec(){
        employeeService = new EmployeeService()
        employeeService.createEmployee("001", "Diana", new Date(), true)
        employeeService.createEmployee("002", "Jorge", new Date(), false)
        employeeService.createEmployee("003", "Luisa", new Date(), true)
        employeeService.createEmployee("004", "Damian", new Date(), false)
        employeeService.createEmployee("005", "Omar", new Date(), true)
    }

    def "Find all the active employees"(){
        setup:
        List<Employee> employees = employeeService.getAllActiveEmployees()

        expect:
        employees.size() == 3
        employees*.name == ["Diana", "Luisa", "Omar"]
        employees*.employeeId == ["001", "003", "005"]
    }

    def "Find employee by name"(){
        setup:
        Employee employee = employeeService.getEmployeeByName("Damian")

        expect:
        employee.name == "Damian"
        employee.employeeId == "004"
        !employee.active
    }

    def "Find employee by employeeId"(){
        setup:
        Employee employee = employeeService.getEmployeeWithId("002")

        expect:
        employee.name == "Jorge"
        employee.employeeId == "002"
        !employee.active
    }

    def "Get all employees ordered by name"(){
        setup:
        List<Employee> employees = employeeService.getAllEmployeesOrderedByName()

        expect:
        employees.size() == 5
        employees*.name == ["Damian","Diana","Jorge", "Luisa", "Omar"]
        employees*.employeeId == ["004", "001", "002",  "003", "005"]
    }

    def "Get all employees ordered by employeeId desc"(){
        setup:
        List<Employee> employees = employeeService.getAllEmployeesOrderedEmployeeIdDesc()

        expect:
        employees.size() == 5
        employees*.name == ["Omar", "Damian", "Luisa","Jorge", "Diana"]
        employees*.employeeId == ["005", "004",  "003","002", "00"] // this line will fail
    }

    def "Create and get new employee"(){
        given:
        Employee employee1 = employeeService.createEmployee("006", "Sandra", new Date(), true)

        when:
        Employee employee2 = employeeService.getEmployeeByName("Sandra")

        then:
        employee1.equals(employee2)
    }


}
