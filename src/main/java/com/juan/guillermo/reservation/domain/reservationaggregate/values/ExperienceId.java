package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class ExperienceId extends Identity {

    private ExperienceId(String uuid) {
        super(uuid);
    }

    public ExperienceId() {
    }

    public static ExperienceId of(String uuid){
        return new ExperienceId(uuid);
    }
}
