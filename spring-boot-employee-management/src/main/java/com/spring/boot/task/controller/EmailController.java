package com.spring.boot.task.controller;

import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.service.EmailService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/allEmails")
    ResponseEntity<List<EmailDto>> getAllEmails() throws SystemException {
        return  ResponseEntity.ok(emailService.getAllEmails());
    }

    @PostMapping("/addEmail")
    ResponseEntity<EmailDto> addEmail(@RequestBody @Valid EmailDto emailDto)throws SystemException {
        return  ResponseEntity.created(URI.create("/addEmail")).body(emailService.addEmail(emailDto));
    }

    @PutMapping("/updateEmail")
    ResponseEntity<EmailDto> updateEmail(@RequestBody @Valid EmailDto emailDto)throws SystemException {
        return ResponseEntity.ok(emailService.updateEmail(emailDto));
    }

    @DeleteMapping("/deleteEmail/{id}")
    ResponseEntity<EmailDto> deleteEmail(@PathVariable Long id)throws SystemException {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();

    }
    //@Valid not for String, can used with Beans ->Dto
    @GetMapping("/getEmailsByType/{type}")
    ResponseEntity<List<EmailDto>> getEmailsByType(@PathVariable String type)throws SystemException {
        return ResponseEntity.ok(emailService.getEmailsByType(type));
    }

    @GetMapping("/getEmailByValue/{value}")
    ResponseEntity<EmailDto> getEmailByValue(@PathVariable  String value)throws SystemException {
        return ResponseEntity.ok(emailService.getEmailByValue(value));
    }

}
