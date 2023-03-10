package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Type implements ValueObject<String> {

    private String value;

    public Type(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
