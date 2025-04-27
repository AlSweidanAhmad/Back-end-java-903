package com.spring.boot.task.service;

import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.model.Email;
import jakarta.transaction.SystemException;

import java.util.List;

public interface EmailService {
    EmailDto addEmail(EmailDto emailDto) throws SystemException;
    EmailDto updateEmail(EmailDto emailDto) throws SystemException;
    void deleteEmail(Long id) throws SystemException;
    List<EmailDto> getAllEmails() throws SystemException;
    List<EmailDto> getEmailsByType(String type) throws SystemException;
    List<EmailDto> getEmailsByListOfTypes(List<String> types) throws SystemException;
    EmailDto getEmailByValue(String value) throws SystemException;

}
