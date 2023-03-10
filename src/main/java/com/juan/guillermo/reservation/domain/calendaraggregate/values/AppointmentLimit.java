package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class AppointmentLimit implements ValueObject<Integer> {

    private final int value;

    public AppointmentLimit(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
