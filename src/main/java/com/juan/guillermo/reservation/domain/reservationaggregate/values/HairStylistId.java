package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class HairStylistId extends Identity {

    private HairStylistId(String uuid) {
        super(uuid);
    }

    public HairStylistId() {
    }

    public static HairStylistId of(String uuid){
        return new HairStylistId(uuid);
    }
}
