package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class CustomerId extends Identity {

    private CustomerId(String uuid) {
        super(uuid);
    }

    public CustomerId() {
    }

    public static CustomerId of(String uuid){
        return new CustomerId(uuid);
    }
}
