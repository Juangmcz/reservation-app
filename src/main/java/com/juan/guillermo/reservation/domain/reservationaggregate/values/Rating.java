package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class Rating implements ValueObject<Double> {

    private final double value;

    public Rating(double value) {
        this.value = value;
    }

    @Override
    public Double value() {
        return value;
    }

}
