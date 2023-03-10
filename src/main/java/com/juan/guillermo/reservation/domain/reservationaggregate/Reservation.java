package com.juan.guillermo.reservation.domain.reservationaggregate;

import com.juan.guillermo.reservation.domain.reservationaggregate.events.*;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.*;
import com.juan.guillermo.reservation.generic.AggregateRoot;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Reservation extends AggregateRoot<ReservationId> {

    protected Customer customer;
    protected HairStylist hairStylist;
    protected Experience experience;
    protected Date date;
    protected Status status;
    protected Comment comment;
    protected IsFulFilled isFulFilled;

    private Reservation(ReservationId reservationId) {
        super(reservationId);
        subscribe(new ReservationChange(this));
    }

    public Reservation(
            ReservationId reservationId,
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

    public void ChangeHairStylist(
            HairStylistId hairStylistId,
            String hairStylistFirstName,
            String hairStylistLastName,
            String hairStylistCell,
            String speciality
    ) {
        Objects.requireNonNull(hairStylistId);
        Objects.requireNonNull(hairStylistFirstName);
        Objects.requireNonNull(hairStylistLastName);
        Objects.requireNonNull(hairStylistCell);
        Objects.requireNonNull(speciality);
        appendChange(new HairStylistChanged(
                hairStylistId.value(),
                hairStylistFirstName,
                hairStylistLastName,
                hairStylistCell,
                speciality
        )).apply();
    }

    public void ChangeCustomerCell(String customerId, String cell){
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(cell);
        appendChange(new CustomerCellChanged(customerId, cell)).apply();
    }

    public void ChangeCustomerSuffix(String customerId, String suffix){
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(suffix);
        appendChange(new CustomerSuffixChanged(customerId, suffix)).apply();
    }

    public void LeaveExperience(String experienceId, double rating, String feedback){
        Objects.requireNonNull(experienceId);
        Objects.requireNonNull(feedback);
        appendChange(new ExperienceLeaved(experienceId, rating, feedback)).apply();
    }

    public void ChangeStatus(String reservationId, String status){
        Objects.requireNonNull(reservationId);
        Objects.requireNonNull(status);
        appendChange(new ReservationStatusChanged(reservationId, status)).apply();
    }

    public void FulFillReservation(String reservationId){
        Objects.requireNonNull(reservationId);
        appendChange(new ReservationFullFilled(reservationId)).apply();
    }
}