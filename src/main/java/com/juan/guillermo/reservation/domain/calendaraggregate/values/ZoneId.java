package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class ZoneId extends Identity {

    private ZoneId(String uuid) {
        super(uuid);
    }

    public ZoneId() {
    }

    public static ZoneId of(String uuid) {
        return new ZoneId(uuid);
    }
}
