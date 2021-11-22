package com.rs.expensetracker.misc;

import com.rs.expensetracker.enums.UserAuthority;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

public class UserAuthorityEnumConverter2 implements Converter<String, UserAuthority> {
    @Override
    public UserAuthority convert(String source) {
        return UserAuthority.fromValue(source);
    }
}
