package com.spring.boot.task.service;

import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.dto.EmployeeDto;
import com.spring.boot.task.model.Email;
import com.spring.boot.task.model.Employee;
import jakarta.transaction.SystemException;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto) throws SystemException;
    EmployeeDto updateEmployee(EmployeeDto employeeDto) throws SystemException;
    void deleteEmployee(Long id) throws SystemException;
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id) throws SystemException;
    List<EmployeeDto> getAllEmployeesByListOfId(List<Long> ids) throws SystemException;
    List<EmployeeDto> getAllEmployeesByListOfName(List<String> names) throws SystemException;
    EmployeeDto addEmployeeWithEmails(EmployeeDto employeeDto, List<Email> emails) throws SystemException;
}
