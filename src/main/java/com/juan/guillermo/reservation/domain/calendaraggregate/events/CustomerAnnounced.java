package com.juan.guillermo.reservation.domain.calendaraggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAnnounced extends DomainEvent {

    private String reservationId;
    private String appointmentId;
    public CustomerAnnounced() {
        super("munoz.juan.customerAnnounced");
    }

    public CustomerAnnounced(String reservationId, String appointmentId){
        super("munoz.juan.customerAnnounced");
        this.reservationId = reservationId;
        this.appointmentId = appointmentId;
    }
}
