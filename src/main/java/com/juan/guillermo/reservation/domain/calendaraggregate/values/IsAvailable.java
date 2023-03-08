package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class IsAvailable implements ValueObject<Boolean> {

    private final Boolean value;

    public IsAvailable(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }
}
