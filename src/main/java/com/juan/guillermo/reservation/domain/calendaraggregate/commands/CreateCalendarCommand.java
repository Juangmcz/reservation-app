package com.juan.guillermo.reservation.domain.calendaraggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCalendarCommand extends Command {

    private String calendarId;
    private String date;
    private int appointmentLimit;

    public CreateCalendarCommand(){}

    public CreateCalendarCommand(String calendarId, String date, int appointmentLimit) {
        this.calendarId = calendarId;
        this.date = date;
        this.appointmentLimit = appointmentLimit;
    }
}
