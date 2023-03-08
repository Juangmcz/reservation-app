package com.juan.guillermo.reservation.domain.calendaraggregate;

import com.juan.guillermo.reservation.domain.calendaraggregate.events.CalendarCreated;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CalendarId;
import com.juan.guillermo.reservation.generic.AggregateRoot;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class Calendar extends AggregateRoot<CalendarId> {

    protected List<Appointment> appointments;

    private Calendar(CalendarId calendarId) {
        super(calendarId);
        subscribe(new CalendarChange(this));
        appendChange(new CalendarCreated()).apply();
    }

    public static Calendar from(CalendarId calendarId, List<DomainEvent> events) {
        Calendar calendar = new Calendar(calendarId);
        events.forEach(calendar::applyEvent);
        return calendar;
    }

}
