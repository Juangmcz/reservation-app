package com.juan.guillermo.reservation.domain.calendaraggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCalendarCommand extends Command {

    private String calendarId;

    public CreateCalendarCommand(){}

    public CreateCalendarCommand(String calendarId) {
        this.calendarId = calendarId;
    }
}
