package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
