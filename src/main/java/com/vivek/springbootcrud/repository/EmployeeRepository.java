package com.vivek.springbootcrud.repository;

import com.vivek.springbootcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
