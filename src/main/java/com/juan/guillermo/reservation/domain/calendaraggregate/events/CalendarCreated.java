package com.juan.guillermo.reservation.domain.calendaraggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarCreated extends DomainEvent {
    public CalendarCreated( ) {
        super("munoz.juan.calendarCreated");
    }
}
