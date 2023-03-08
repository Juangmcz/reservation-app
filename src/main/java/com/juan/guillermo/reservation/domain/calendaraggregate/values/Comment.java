package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Comment implements ValueObject<String> {

    private final String value;

    public Comment(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
