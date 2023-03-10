package com.juan.guillermo.reservation.domain.calendaraggregate;

import com.juan.guillermo.reservation.domain.calendaraggregate.values.AppointmentId;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CustomerArrived;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.Date;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.Status;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.Entity;

public class Appointment extends Entity<AppointmentId> {

    private ReservationId reservationId;
    private Detail detail;
    private Zone zone;
    private Date date;
    private Status status;
    private CustomerArrived customerArrived;

    public Appointment(AppointmentId appointmentId, ReservationId reservationId, Detail detail, Zone zone, Date date) {
        super(appointmentId);
        this.reservationId = reservationId;
        this.detail = detail;
        this.zone = zone;
        this.date = date;
        this.status = new Status("Active");
        this.customerArrived = new CustomerArrived(false);
    }

    public ReservationId reservationId() {
        return reservationId;
    }

    public Detail detail() {
        return detail;
    }

    public Zone zone() {
        return zone;
    }

    public Date date() {
        return date;
    }

    public Status status() {
        return status;
    }

    public CustomerArrived customerArrived() {
        return customerArrived;
    }

    public void CustomerHasArrived() {
        this.customerArrived = new CustomerArrived(true);
    }

    public void ChangeDate(String date) {
        this.date = new Date(date);
    }

}
