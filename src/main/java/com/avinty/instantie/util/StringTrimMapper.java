package com.avinty.instantie.util;

import org.springframework.stereotype.Component;

@Component
public class StringTrimMapper {

    public String trim(String value) {
        return value == null ? null : value.trim();
    }
}
