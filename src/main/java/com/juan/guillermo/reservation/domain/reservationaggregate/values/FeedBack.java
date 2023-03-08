package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class FeedBack implements ValueObject<String> {

    private String value;

    public FeedBack(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}
