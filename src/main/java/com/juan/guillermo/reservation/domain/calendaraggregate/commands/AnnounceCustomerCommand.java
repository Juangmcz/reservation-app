package com.juan.guillermo.reservation.domain.calendaraggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnounceCustomerCommand extends Command {

    private String calendarId;
    private String reservationId;
    private String appointmentId;

    public AnnounceCustomerCommand() {}

    public AnnounceCustomerCommand(String calendarId, String reservationId, String appointmentId){
        this.calendarId = calendarId;
        this.reservationId = reservationId;
        this.appointmentId = appointmentId;
    }
}
