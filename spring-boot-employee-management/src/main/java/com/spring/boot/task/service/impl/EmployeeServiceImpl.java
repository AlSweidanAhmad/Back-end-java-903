package com.spring.boot.task.service.impl;

import com.spring.boot.task.dto.EmployeeDto;
import com.spring.boot.task.mapper.EmployeeMapper;
import com.spring.boot.task.model.Email;
import com.spring.boot.task.model.Employee;
import com.spring.boot.task.repo.EmployeeRepo;
import com.spring.boot.task.service.EmployeeService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) throws SystemException {
        if (Objects.nonNull(employeeDto.getId())){
            throw new SystemException("Cannot create a new employee with an existing ID. ID must be null.");
        }

        Employee employee = employeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);
        return employeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws SystemException {
        if (Objects.isNull(employeeDto.getId())){
            throw new SystemException("Cannot update Employee without an ID. Please provide the employee ID.");
        }

        Optional<Employee> employeeOptional = employeeRepo.findById(employeeDto.getId());
        if (employeeOptional.isEmpty()){
            throw new SystemException("Employee not found for update.");
        }

        Employee employee = employeeMapper.toEmployee(employeeDto);
        Employee updated = employeeRepo.save(employee);
        return employeeMapper.toEmployeeDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) throws SystemException {
        if (Objects.isNull(id)){
            throw new SystemException("Cannot delete employee without an ID. Please provide a valid employee ID.");
        }
        employeeRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employeeMapper.toEmployeeDtoList(employees);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) throws SystemException {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isEmpty()){
            throw new SystemException("Id: " + id + " not found.");
        }
        return employeeMapper.toEmployeeDto(employeeOptional.get());
    }

    @Override
    public List<EmployeeDto> getAllEmployeesByListOfId(List<Long> ids) throws SystemException {
        List<Employee> employees = employeeRepo.findAllById(ids);
        if (Objects.isNull(ids) || ids.isEmpty()){
            throw new SystemException("ID list must not be null or empty.");
        }

        if (employees.isEmpty()){
            throw new SystemException("No employees found for the provided IDs.");
        }
        return employeeMapper.toEmployeeDtoList(employees);
    }

    @Override
    public List<EmployeeDto> getAllEmployeesByListOfName(List<String> names) throws SystemException {
        List<Employee> employees = employeeRepo.findAllByNameInIgnoreCase(names);
        if (Objects.isNull(names) || employees==null){
            throw new SystemException("Name list must not be null or empty.");
        }
        return employeeMapper.toEmployeeDtoList(employees);
    }

    @Override
    public EmployeeDto addEmployeeWithEmails(EmployeeDto employeeDto, List<Email> emails) throws SystemException {
        if(Objects.isNull(employeeDto)){
            throw new SystemException("Employee data is required");
        }

        Employee employee = employeeMapper.toEmployee(employeeDto);

        for (Email email : emails){
            email.setEmployee(employee);
        }

        employee.setEmails(emails);

        employeeRepo.save(employee);

        return employeeMapper.toEmployeeDto(employee);
    }
}
