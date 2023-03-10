package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name implements ValueObject<String> {

    private final String value;
    private static final String NAME_REGEX = "^[a-zA-Z\\s']+$";

    public Name(String value) {

        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(value);

        if(matcher.matches()){
            this.value = value;
        }else{
            throw new IllegalArgumentException("Please, enter a valid name");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
