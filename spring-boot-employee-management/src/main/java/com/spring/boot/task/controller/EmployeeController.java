package com.spring.boot.task.controller;

import com.spring.boot.task.dto.EmployeeDto;
import com.spring.boot.task.model.Email;
import com.spring.boot.task.model.Employee;
import com.spring.boot.task.service.EmployeeService;
import com.spring.boot.task.service.impl.EmployeeServiceImpl;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployee")
    ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("/addEmployee")
    ResponseEntity<EmployeeDto> addEmployee(@RequestBody @Valid EmployeeDto employeeDto)throws SystemException {
        return  ResponseEntity.created(URI.create("/addEmployee")).body(employeeService.addEmployee(employeeDto));
    }

    @PutMapping("/updateEmployee")
    ResponseEntity<EmployeeDto> updateEmployee(@RequestBody @Valid EmployeeDto employeeDto)throws SystemException {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }

    @DeleteMapping("/deleteEmployee/{id}")
    ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long id)throws SystemException {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/getEmployeeById/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id)throws SystemException {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/getEmployeesByIds")
    ResponseEntity<List<EmployeeDto>> getAllEmployeesByListOfId(@RequestParam @Valid List<Long> ids)throws SystemException {
        return ResponseEntity.ok(employeeService.getAllEmployeesByListOfId(ids));
    }

    @GetMapping("/getEmployeesByNames")
    ResponseEntity<List<EmployeeDto>> getAllEmployeesByListOfName(@RequestParam @Valid List<String> names) throws SystemException {
        return ResponseEntity.ok(employeeService.getAllEmployeesByListOfName(names));
    }
/* Error: HttpMessageNotReadableException: Required request body is missing

    @PostMapping("/addEmployeeWithEmails")
    ResponseEntity<EmployeeDto> addEmployeeWithEmails(@RequestBody EmployeeDto employeeDto, List<Email> emails)  throws SystemException {
        return ResponseEntity.created(URI.create("/addEmployeeWithEmails")).body(employeeService.addEmployeeWithEmails(employeeDto,emails));
    }

 */
}
