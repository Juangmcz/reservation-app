package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Status implements ValueObject<String> {

    private final String value;

    public Status(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
