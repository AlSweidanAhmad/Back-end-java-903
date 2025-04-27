package com.spring.boot.task.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "Name must not be empty")
    private String name;
    //@Size(min = 15, max = 40)
    @Min(value = 15, message = "Age must be at least 15")
    @Max(value = 40, message = "Age must be at most 40")
    private int age;
    //@Size(min = 5000, max = 10000)
    @Min(value = 5000, message = "Salary must be at least 5000")
    @Max(value = 10000, message = "Salary must be at most 10000")
    private double salary;
}
