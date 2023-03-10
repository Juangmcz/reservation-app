package com.juan.guillermo.reservation.domain.reservationaggregate;

import com.juan.guillermo.reservation.domain.reservationaggregate.events.*;
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
            reservation.status = new Status("Created");
            reservation.isFulFilled = new IsFulFilled(false);
        });

        apply((HairStylistChanged event) -> reservation.hairStylist = new HairStylist(
                new HairStylistId(),
                new FullName(event.getHairStylistFirstName(), event.getHairStylistLastName()),
                new Cell(event.getHairStylistCell()),
                new Speciality(event.getSpeciality())
        ));

        apply((CustomerCellChanged event) -> reservation.customer.ChangeCell(event.getCell()));

        apply((CustomerSuffixChanged event) -> reservation.customer.ChangeSuffix(event.getSuffix()));

        apply((ExperienceLeaved event) -> reservation.experience = new Experience(new ExperienceId(),
                new Rating(event.getRating()),
                new FeedBack(event.getFeedback())
        ));

        apply((ReservationStatusChanged event) -> reservation.status = new Status(event.getStatus()));

        apply((ReservationFullFilled event) -> reservation.isFulFilled = new IsFulFilled(true));
    }
}
