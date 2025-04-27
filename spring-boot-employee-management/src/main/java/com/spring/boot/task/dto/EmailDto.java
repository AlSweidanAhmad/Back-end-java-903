package com.spring.boot.task.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.naming.factory.SendMailFactory;

@Data
public class EmailDto {
    private Long id;
    @NotEmpty(message = "Please select an valid email type like (e.g., Gmail, Yahoo).")
    private String type;
    @NotEmpty(message = "Please provide an email address (e.g., example@gmail.com).")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid email format. Please enter a valid email address (e.g., example@gmail.com)."
    )
    private String value;
}
