package com.spring.boot.task.mapper;

import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.model.Email;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {


    EmailDto toEmailDto(Email email);
    Email toEmail(EmailDto emailDto);
    List<Email> toEmailList(List<EmailDto> emailDtos);
    List<EmailDto> toEmailDtoList(List<Email> emails);
}
