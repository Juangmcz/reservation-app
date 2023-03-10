package com.juan.guillermo.reservation.domain.calendaraggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeAppointmentStatusCommand extends Command {

    private String calendarId;
    private String reservationId;
    private String status;

    public ChangeAppointmentStatusCommand(){}

    public ChangeAppointmentStatusCommand(String calendarId, String reservationId, String status) {
        this.calendarId = calendarId;
        this.reservationId = reservationId;
        this.status = status;
    }
}
