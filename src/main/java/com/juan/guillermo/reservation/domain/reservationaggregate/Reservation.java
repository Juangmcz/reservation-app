package com.juan.guillermo.reservation.domain.reservationaggregate;

import com.juan.guillermo.reservation.domain.reservationaggregate.events.ReservationCreated;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.Comment;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.Date;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.Status;
import com.juan.guillermo.reservation.generic.AggregateRoot;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class Reservation extends AggregateRoot<ReservationId> {

    protected Customer customer;
    protected HairStylist hairStylist;
    protected Experience experience;
    protected Date date;
    protected Status status;
    protected Comment comment;

    private Reservation(ReservationId reservationId) {
        super(reservationId);
        subscribe(new ReservationChange(this));
    }

    public Reservation(ReservationId reservationId,
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
        super(reservationId);
        appendChange(
                new ReservationCreated(
                        date,
                        comment,
                        customerFirstName,
                        customerLastName,
                        customerCell,
                        suffix,
                        hairStylistFirstName,
                        hairStylistLastName,
                        hairStylistCell,
                        speciality
        )).apply();
    }

    public static Reservation from(ReservationId reservationId, List<DomainEvent> events) {
        Reservation reservation = new Reservation(reservationId);
        events.forEach(reservation::applyEvent);
        return reservation;
    }
}
