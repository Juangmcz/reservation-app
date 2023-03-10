package com.juan.guillermo.reservation.domain.calendaraggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeAppointmentDateCommand extends Command {

    private String calendarId;
    private String appointmentId;
    private String date;

    public ChangeAppointmentDateCommand() {}

    public ChangeAppointmentDateCommand(String calendarId, String appointmentId, String date) {
        this.calendarId = calendarId;
        this.appointmentId = appointmentId;
        this.date = date;
    }
}
