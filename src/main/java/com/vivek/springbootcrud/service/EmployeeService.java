package com.vivek.springbootcrud.service;

import com.vivek.springbootcrud.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    String updateEmployee(Employee employee);

    String deleteEmployee(int id);

}
