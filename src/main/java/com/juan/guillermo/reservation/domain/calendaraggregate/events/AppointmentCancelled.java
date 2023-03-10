package com.juan.guillermo.reservation.domain.calendaraggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentCancelled extends DomainEvent {
    private String appointmentId;

    public AppointmentCancelled() { super("munoz.juan.appointmentCancelled");}

    public AppointmentCancelled(String appointmentId) {
        super("munoz.juan.appointmentCancelled");
        this.appointmentId = appointmentId;
    }
}
