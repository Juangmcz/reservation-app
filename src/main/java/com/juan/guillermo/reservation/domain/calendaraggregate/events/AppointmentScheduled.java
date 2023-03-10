package com.juan.guillermo.reservation.domain.calendaraggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentScheduled extends DomainEvent {

    private String appointmentId;
    private String reservationId;
    private String detailId;
    private String date;
    private String comment;
    private String zoneId;
    private String name;
    private String type;

    public AppointmentScheduled() { super("munoz.juan.appointmentScheduled");}
    public AppointmentScheduled(
            String appointmentId,
            String reservationId,
            String detailId,
            String date,
            String comment,
            String zoneId,
            String name,
            String type
    ) {
        super("munoz.juan.appointmentScheduled");
        this.appointmentId = appointmentId;
        this.reservationId = reservationId;
        this.detailId = detailId;
        this.date = date;
        this.comment = comment;
        this.zoneId = zoneId;
        this.name = name;
        this.type = type;
    }
}
