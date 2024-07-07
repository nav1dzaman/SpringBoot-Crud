package com.javacrud.JavaCrudPro.repository;

import com.javacrud.JavaCrudPro.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
