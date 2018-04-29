package com.nearsoft.groovy.example3

import com.nearsoft.java.example3.Employee

class EmployeeService {

    List<Employee> employees = []

    def createEmployee(String employeeId, String name, Date date, boolean active){
        Employee employee = new Employee()
        employee.with {
            setName(name)
            setEmployeeId(employeeId)
            setActive(active)
            startDate = date // since this name is different
        }
        employees << employee
        employee
    }

    def getEmployeeWithId(String employeeId){
        employees.find({ employee ->
            employee.employeeId == employeeId
        })
    }

    def getEmployeeByName(String name){
        employees.find({ employee ->
            employee.name == name
        })
    }

    def getAllActiveEmployees(){
        employees.findAll({ employee ->
            employee.active
        })
    }

    def getAllEmployeesOrderedByName(){
        employees.sort{ it.name }
    }

    def getAllEmployeesOrderedEmployeeIdDesc(){
        employees.sort{ it.employeeId }.reverse()
    }
}
