package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class IsFulFilled implements ValueObject<Boolean> {

    private Boolean value;

    public IsFulFilled(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }
}