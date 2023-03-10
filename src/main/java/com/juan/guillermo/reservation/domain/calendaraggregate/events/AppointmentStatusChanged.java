package com.juan.guillermo.reservation.domain.calendaraggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentStatusChanged extends DomainEvent {

    private String appointmentId;
    private String reservationId;
    private String status;

    public AppointmentStatusChanged(){ super("munoz.juan.appointmentStatusChanged"); }

    public AppointmentStatusChanged(String appointmentId, String reservationId, String status) {
        super("munoz.juan.appointmentStatusChanged");
        this.appointmentId = appointmentId;
        this.reservationId = reservationId;
        this.status = status;
    }
}
