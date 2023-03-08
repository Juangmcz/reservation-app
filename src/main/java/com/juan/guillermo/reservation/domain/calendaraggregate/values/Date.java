package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Date implements ValueObject<String> {

    private final String value;

    public Date(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
