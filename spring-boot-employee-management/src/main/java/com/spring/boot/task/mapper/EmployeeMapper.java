package com.spring.boot.task.mapper;

import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.dto.EmployeeDto;
import com.spring.boot.task.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployee(EmployeeDto EmployeeDto);
    EmployeeDto toEmployeeDto(Employee employee);
    List<Employee> toEmployeeList(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);

}
