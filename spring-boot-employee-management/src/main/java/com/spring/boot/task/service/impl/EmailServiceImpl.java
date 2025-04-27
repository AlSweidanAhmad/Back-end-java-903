package com.spring.boot.task.service.impl;

import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.mapper.EmailMapper;
import com.spring.boot.task.model.Email;
import com.spring.boot.task.repo.EmailRepo;
import com.spring.boot.task.service.EmailService;
import jakarta.transaction.SystemException;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailMapper emailMapper;
    @Autowired
    private EmailRepo emailRepo;

    @Override
    public EmailDto addEmail(EmailDto emailDto) throws SystemException {
        if (Objects.nonNull(emailDto.getId())){
            throw new SystemException("Cannot create a new email with an existing ID. ID must be null.");
        }
        Email email = emailMapper.toEmail(emailDto);
        Email savedEmail = emailRepo.save(email);
        return emailMapper.toEmailDto(savedEmail);
    }

    @Override
    public EmailDto updateEmail(EmailDto emailDto) throws SystemException {
        if (Objects.isNull(emailDto.getId())){
            throw new SystemException("Cannot update email without an ID. Please provide the email ID.");
        }

        Email email = emailMapper.toEmail(emailDto);
        emailRepo.save(email);

        return emailDto;
    }

    @Override
    public void deleteEmail(Long id) throws SystemException {
        if (Objects.isNull(id)){
            throw new SystemException("Cannot delete email without an ID. Please provide a valid email ID.");
        }
        emailRepo.deleteById(id);
    }

    @Override
    public List<EmailDto> getAllEmails() throws SystemException {
        List<Email> emails = emailRepo.findAll();
        return emailMapper.toEmailDtoList(emails);
    }

    @Override
    public List<EmailDto> getEmailsByType(String type) throws SystemException {
        if (Objects.isNull(type)){
            throw new SystemException("Email type is required. Please provide a valid type.");
        }
        List<Email> emails = emailRepo.findByType(type);

        return emailMapper.toEmailDtoList(emails);
    }

    @Override
    public List<EmailDto> getEmailsByListOfTypes(List<String> types) throws SystemException {
        if (Objects.isNull(types)){
            throw new SystemException("A list of email types is required. Please provide one or more types.");
        }
        List<Email> emails = emailRepo.findByTypeIn(types);

        return emailMapper.toEmailDtoList(emails);
    }

    @Override
    public EmailDto getEmailByValue(String value) throws SystemException {
        Optional<Email> emailOptional = emailRepo.findByValue(value);
        if (emailOptional.isEmpty()){
            throw new SystemException("No email found with the specified content/value.");
        }

        return emailMapper.toEmailDto(emailOptional.get());
    }


}
