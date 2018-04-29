package com.nearsoft.java.example3;

import groovyjarjarantlr.StringUtils;
import org.codehaus.groovy.util.StringUtil;

import java.util.Date;

public class Employee {

    private String employeeId;
    private String name;
    private Date startDate;
    private boolean active;

    public Employee() {
    }

    public Employee(String employeeId, String name, Date startDate, boolean active) {
        this.employeeId = employeeId;
        this.name = name;
        this.startDate = startDate;
        this.active = active;
    }

    public static class EmployeeBuilder {
        private String employeeId;
        private String name;
        private Date startDate;
        private boolean active;

        public EmployeeBuilder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public EmployeeBuilder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public Employee createEmployee() {
            return new Employee(employeeId, name, startDate, active);
        }
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new RuntimeException("The name can't be null");
        }
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        if (active != employee.active)
            return false;
        if (employeeId != null ?
                !employeeId.equals(employee.employeeId) :
                employee.employeeId != null)
            return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null)
            return false;
        return startDate != null ?
                startDate.equals(employee.startDate) :
                employee.startDate == null;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId='" + employeeId + '\'' + ", name='" + name + '\''
                + ", startDate=" + startDate + ", active=" + active + '}';
    }
}
