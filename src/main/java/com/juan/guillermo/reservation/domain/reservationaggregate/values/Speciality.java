package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Speciality implements ValueObject<String> {

    private final String value;

    public Speciality(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
