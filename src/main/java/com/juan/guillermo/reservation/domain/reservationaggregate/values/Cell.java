package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cell implements ValueObject<String> {

    private final String value;
    private static final String CELL_REGEX = "^\\d{10}$";

    public Cell(String value) {

        Pattern pattern = Pattern.compile(CELL_REGEX);
        Matcher matcher = pattern.matcher(value);

        if(matcher.matches()){
            this.value = value;
        }else{
            throw new IllegalArgumentException("Please, enter a valid Cellphone number");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
