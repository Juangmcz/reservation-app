package com.juan.guillermo.reservation.domain.reservationaggregate;

import com.juan.guillermo.reservation.domain.reservationaggregate.events.ReservationCreated;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.*;
import com.juan.guillermo.reservation.generic.EventChange;

public class ReservationChange extends EventChange {

    public ReservationChange(Reservation reservation){

        apply((ReservationCreated event) -> {
            Customer customer = new Customer(new CustomerId(),
                    new FullName(event.getCustomerFirstName(), event.getCustomerLastName()),
                    new Cell(event.getCustomerCell()),
                    new Suffix(event.getSuffix())
            );
            HairStylist hairStylist = new HairStylist(new HairStylistId(),
                    new FullName(event.getHairStylistFirstName(), event.getHairStylistLastName()),
                    new Cell(event.getHairStylistCell()),
                    new Speciality(event.getSpeciality())
            );
            reservation.customer = customer;
            reservation.hairStylist = hairStylist;
            reservation.comment = new Comment(event.getComment());
        });
    }
}
