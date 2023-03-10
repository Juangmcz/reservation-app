package com.juan.guillermo.reservation.domain.calendaraggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarCreated extends DomainEvent {

    private String date;
    private int appointmentLimit;
    public CalendarCreated( ) {
        super("munoz.juan.calendarCreated");
    }

    public CalendarCreated(String date, int appointmentLimit) {
        super("munoz.juan.calendarCreated");
        this.date = date;
        this.appointmentLimit = appointmentLimit;
    }
}
