package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class CustomerArrived implements ValueObject<Boolean> {

    private final Boolean value;

    public CustomerArrived(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }

}
