package com.juan.guillermo.reservation.domain.calendaraggregate.values;

import com.juan.guillermo.reservation.generic.Identity;

public class CalendarId extends Identity {

    private CalendarId(String uuid) {
        super(uuid);
    }

    public CalendarId() {
    }

    public static CalendarId of(String uuid) {
        return new CalendarId(uuid);
    }
}
