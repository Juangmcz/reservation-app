package com.juan.guillermo.reservation.domain.reservationaggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationCreated extends DomainEvent {

    private String date;
    private String comment;
    private String customerFirstName;
    private String customerLastName;
    private String customerCell;
    private String suffix;
    private String hairStylistFirstName;
    private String hairStylistLastName;
    private String hairStylistCell;
    private String speciality;

    public ReservationCreated() {
        super("munoz.juan.reservationCreated");
    }

    public ReservationCreated(
            String date,
            String comment,
            String customerFirstName,
            String customerLastName,
            String customerCell,
            String suffix,
            String hairStylistFirstName,
            String hairStylistLastName,
            String hairStylistCell,
            String speciality
    ) {
        super("munoz.juan.reservationCreated");
        this.date = date;
        this.comment = comment;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCell = customerCell;
        this.suffix = suffix;
        this.hairStylistFirstName = hairStylistFirstName;
        this.hairStylistLastName = hairStylistLastName;
        this.hairStylistCell = hairStylistCell;
        this.speciality = speciality;
    }
}
