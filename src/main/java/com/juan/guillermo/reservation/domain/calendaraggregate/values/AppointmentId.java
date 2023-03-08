package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class AppointmentId extends Identity {

    private AppointmentId(String uuid) {
        super(uuid);
    }

    public AppointmentId() {
    }

    public static AppointmentId of(String uuid) {
        return new AppointmentId(uuid);
    }
}
