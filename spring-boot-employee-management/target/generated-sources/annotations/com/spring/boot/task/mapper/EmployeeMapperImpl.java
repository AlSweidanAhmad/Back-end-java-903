package com.spring.boot.task.mapper;

import com.spring.boot.task.dto.EmployeeDto;
import com.spring.boot.task.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-27T11:24:13+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.14 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEmployee(EmployeeDto EmployeeDto) {
        if ( EmployeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( EmployeeDto.getId() );
        employee.setName( EmployeeDto.getName() );
        employee.setAge( EmployeeDto.getAge() );
        employee.setSalary( EmployeeDto.getSalary() );

        return employee;
    }

    @Override
    public EmployeeDto toEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setAge( employee.getAge() );
        employeeDto.setSalary( employee.getSalary() );

        return employeeDto;
    }

    @Override
    public List<Employee> toEmployeeList(List<EmployeeDto> employeeDtos) {
        if ( employeeDtos == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeDtos.size() );
        for ( EmployeeDto employeeDto : employeeDtos ) {
            list.add( toEmployee( employeeDto ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDto> toEmployeeDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toEmployeeDto( employee ) );
        }

        return list;
    }
}
