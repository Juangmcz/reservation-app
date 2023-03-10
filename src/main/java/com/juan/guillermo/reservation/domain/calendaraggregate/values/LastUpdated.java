package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

import java.time.LocalDate;

public class LastUpdated implements ValueObject<LocalDate> {

    private final LocalDate value;

    public LastUpdated() {
        this.value = LocalDate.now();
    }

    @Override
    public LocalDate value() {
        return value;
    }

}
