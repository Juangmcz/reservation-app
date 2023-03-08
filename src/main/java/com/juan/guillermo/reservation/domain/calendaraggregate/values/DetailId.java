package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class DetailId extends Identity {

    private DetailId(String uuid) {
        super(uuid);
    }

    public DetailId() {
    }

    public static DetailId of(String uuid){
        return new DetailId(uuid);
    }
}
