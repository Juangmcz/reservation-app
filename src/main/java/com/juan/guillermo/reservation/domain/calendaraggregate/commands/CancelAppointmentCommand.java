package com.juan.guillermo.reservation.domain.calendaraggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelAppointmentCommand extends Command {

    private String calendarId;
    private String appointmentId;

    public CancelAppointmentCommand() {}
    public CancelAppointmentCommand(String calendarId, String appointmentId) {
        this.calendarId = calendarId;
        this.appointmentId = appointmentId;
    }
}
