package com.juan.guillermo.reservation.domain.calendaraggregate;

import com.juan.guillermo.reservation.domain.calendaraggregate.events.*;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.*;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.EventChange;

import java.util.ArrayList;

public class CalendarChange extends EventChange {

    public CalendarChange(Calendar calendar) {

        apply((CalendarCreated event) -> {
            calendar.date = new Date(event.getDate());
            calendar.appointmentLimit = new AppointmentLimit(event.getAppointmentLimit());
            calendar.appointments = new ArrayList<>();
        });

        apply((CustomerAnnounced event) -> {
            Appointment appointment = calendar.appointments.stream()
                .filter(foundAppointment -> foundAppointment.identity().value().equals(event.getAppointmentId()))
                .findFirst().orElseThrow();
            appointment.CustomerHasArrived();
        });

        apply((AppointmentScheduled event) -> {
            Appointment appointment = new Appointment(AppointmentId.of(event.getAppointmentId()),
                    ReservationId.of(event.getReservationId()),
                    new Detail(DetailId.of(event.getDetailId()), new Comment(event.getComment())),
                    new Zone(ZoneId.of(event.getZoneId()), new Name(event.getName()), new Type(event.getType())),
                    new Date(event.getDate())
                    );
            calendar.appointments.add(appointment);
        });

        apply((AppointmentCancelled event) -> calendar.appointments.forEach(appointment -> {
            if (appointment.identity().value().equals(event.getAppointmentId())){
                calendar.appointments.remove(appointment);
            }
        }));

        apply((AppointmentDateChanged event) -> {
            Appointment appointment = calendar.appointments.stream()
                    .filter(foundAppointment -> foundAppointment.identity().value().equals(event.getAppointmentId()))
                    .findFirst().orElseThrow();
            appointment.ChangeDate(event.getDate());
        });
    }
}