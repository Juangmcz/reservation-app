package com.juan.guillermo.reservation.domain.reservationaggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationFullFilled  extends DomainEvent{

    private String reservationId;

    public ReservationFullFilled(){ super("munoz.juan.reservationFullFilled"); }

    public ReservationFullFilled(String reservationId) {
        super("munoz.juan.reservationFullFilled");
        this.reservationId = reservationId;
    }
}
