package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class ReservationId extends Identity {

    private ReservationId(String uuid) {
        super(uuid);
    }

    public ReservationId() {
    }

    public static ReservationId of(String uuid){
        return new ReservationId(uuid);
    }
}
