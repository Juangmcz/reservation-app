package com.juan.guillermo.reservation.domain.reservationaggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationStatusChanged extends DomainEvent {

    private String reservationId;
    private String status;
    public ReservationStatusChanged(){ super("munoz.juan.reservationStatusChanged"); }

    public ReservationStatusChanged(String reservationId, String status) {
        super("munoz.juan.reservationStatusChanged");
        this.reservationId = reservationId;
        this.status = status;
    }
}
