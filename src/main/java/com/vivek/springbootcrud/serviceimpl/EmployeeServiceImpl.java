package com.vivek.springbootcrud.serviceimpl;

import com.vivek.springbootcrud.model.Employee;
import com.vivek.springbootcrud.repository.EmployeeRepository;
import com.vivek.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public String updateEmployee(Employee employee) {
        Employee employeeToBeUpdated = employeeRepository.findById(employee.getEmpId()).orElse(null);
        if (employeeToBeUpdated != null) {
            employeeToBeUpdated.setEmpName(employee.getEmpName());
            employeeToBeUpdated.setEmpSalary(employee.getEmpSalary());
            employeeToBeUpdated.setEmpDept(employee.getEmpDept());
            employeeRepository.save(employeeToBeUpdated);
            return "Employee updated successfully with id: " + employee.getEmpId();
        } else {
            return "Requested Employee id does not exist: " + employee.getEmpId();
        }
    }

    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully with id: " + id;
    }

}
