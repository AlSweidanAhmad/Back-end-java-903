package com.spring.boot.task.mapper;

import com.spring.boot.task.dto.EmailDto;
import com.spring.boot.task.model.Email;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-27T11:24:12+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.14 (Eclipse Adoptium)"
)
@Component
public class EmailMapperImpl implements EmailMapper {

    @Override
    public EmailDto toEmailDto(Email email) {
        if ( email == null ) {
            return null;
        }

        EmailDto emailDto = new EmailDto();

        emailDto.setId( email.getId() );
        emailDto.setType( email.getType() );
        emailDto.setValue( email.getValue() );

        return emailDto;
    }

    @Override
    public Email toEmail(EmailDto emailDto) {
        if ( emailDto == null ) {
            return null;
        }

        Email email = new Email();

        email.setId( emailDto.getId() );
        email.setType( emailDto.getType() );
        email.setValue( emailDto.getValue() );

        return email;
    }

    @Override
    public List<Email> toEmailList(List<EmailDto> emailDtos) {
        if ( emailDtos == null ) {
            return null;
        }

        List<Email> list = new ArrayList<Email>( emailDtos.size() );
        for ( EmailDto emailDto : emailDtos ) {
            list.add( toEmail( emailDto ) );
        }

        return list;
    }

    @Override
    public List<EmailDto> toEmailDtoList(List<Email> emails) {
        if ( emails == null ) {
            return null;
        }

        List<EmailDto> list = new ArrayList<EmailDto>( emails.size() );
        for ( Email email : emails ) {
            list.add( toEmailDto( email ) );
        }

        return list;
    }
}
