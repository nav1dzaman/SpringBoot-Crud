package com.javacrud.JavaCrudPro.service.impl;

import com.javacrud.JavaCrudPro.dto.EmployeeDto;
import com.javacrud.JavaCrudPro.entity.Employee;
import com.javacrud.JavaCrudPro.mapper.EmployeeMapper;
import com.javacrud.JavaCrudPro.repository.EmployeeRepository;
import com.javacrud.JavaCrudPro.service.EmployeeService;
import lombok.AllArgsConstructor;
import net.javaguides.ems.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository  employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeedto) {
         Employee employee= EmployeeMapper.mapToEmployee(employeedto);
         Employee saved= employeeRepository.save(employee);
        return EmployeeMapper.mapTOEmployeeDto(saved);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee;
        employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: "));
        return EmployeeMapper.mapTOEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapTOEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {


            Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                    () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
            );

            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());

            Employee updatedEmployeeObj = employeeRepository.save(employee);

            return EmployeeMapper.mapTOEmployeeDto(updatedEmployeeObj);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }


}
