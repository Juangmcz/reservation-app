package com.juan.guillermo.reservation.domain.calendaraggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleAppointmentCommand extends Command {

    private String calendarId;
    private String appointmentId;
    private String reservationId;
    private String detailId;
    private String date;
    private String comment;
    private String zoneId;
    private String name;
    private String type;

    public ScheduleAppointmentCommand() {}
    public ScheduleAppointmentCommand(
            String calendarId,
            String appointmentId,
            String reservationId,
            String detailId,
            String date,
            String comment,
            String zoneId,
            String name,
            String type
    ) {
        this.calendarId = calendarId;
        this.appointmentId = appointmentId;
        this.reservationId = reservationId;
        this.detailId = detailId;
        this.date = date;
        this.comment = comment;
        this.zoneId = zoneId;
        this.name = name;
        this.type = type;
    }
}
