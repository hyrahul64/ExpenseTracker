package com.rs.expensetracker.misc;

import com.rs.expensetracker.enums.UserAuthority;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class UserAuthorityEnumConverter implements HttpMessageConverter<UserAuthority> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return clazz == UserAuthority.class;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return new LinkedList<>();
    }

    @Override
    public UserAuthority read(Class<? extends UserAuthority> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("UserAuthorityEnumConverter::read()");
        return UserAuthority.fromValue(inputMessage.getBody().toString());
    }

    @Override
    public void write(UserAuthority userAuthority, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write(userAuthority.toString().getBytes(StandardCharsets.UTF_8));
    }
}
