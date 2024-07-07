package com.javacrud.JavaCrudPro.mapper;

import com.javacrud.JavaCrudPro.dto.EmployeeDto;
import com.javacrud.JavaCrudPro.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapTOEmployeeDto(Employee employee){
        return new EmployeeDto(
              employee.getId(),
                employee.getName(),
                employee.getEmail()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail()
        );
    }
}
