package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Suffix implements ValueObject<String> {

    private final String value;

    public Suffix(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
