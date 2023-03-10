package com.juan.guillermo.reservation.domain.calendaraggregate;

import com.juan.guillermo.reservation.domain.calendaraggregate.events.*;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.AppointmentLimit;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CalendarId;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.Date;
import com.juan.guillermo.reservation.generic.AggregateRoot;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class Calendar extends AggregateRoot<CalendarId> {

    protected Date date;
    protected AppointmentLimit appointmentLimit;
    protected List<Appointment> appointments;

    private Calendar(CalendarId calendarId) {
        super(calendarId);
        subscribe(new CalendarChange(this));
    }

    public Calendar(CalendarId calendarId, String date, int appointmentLimit) {
        super(calendarId);
        subscribe(new CalendarChange(this));
        appendChange(new CalendarCreated(date, appointmentLimit)).apply();
    }

    public static Calendar from(CalendarId calendarId, List<DomainEvent> events) {
        Calendar calendar = new Calendar(calendarId);
        events.forEach(calendar::applyEvent);
        return calendar;
    }

    public void AnnounceCustomer(String reservationId, String appointmentId) {
        appendChange(new CustomerAnnounced(reservationId, appointmentId)).apply();
    }

    public void ScheduleAppointment(
            String appointmentId,
            String reservationId,
            String detailId,
            String date,
            String comment,
            String zoneId,
            String name,
            String type
    ) { appendChange(new AppointmentScheduled(
            appointmentId,
            reservationId,
            detailId,
            date,
            comment,
            zoneId,
            name,
            type
            )).apply(); }

    public void CancelAppointment(String appointmentId){
        appendChange(new AppointmentCancelled(appointmentId)).apply();
    }

    public void ChangeAppointmentDate(String appointmentId, String date){
        appendChange(new AppointmentDateChanged(appointmentId, date)).apply();
    }

    public void ChangeAppointmentStatus(String appointmentId, String reservationId, String status){
        appendChange(new AppointmentStatusChanged(appointmentId,reservationId, status)).apply();
    }
}
