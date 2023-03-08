package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Comment implements ValueObject<String> {

    private String value;

    public Comment(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}