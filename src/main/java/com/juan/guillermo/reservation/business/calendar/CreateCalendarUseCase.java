package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.Calendar;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.CreateCalendarCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CalendarId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class CreateCalendarUseCase implements UseCaseForCommand<CreateCalendarCommand> {

    private final EventsRepository eventsRepository;

    public CreateCalendarUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateCalendarCommand command) {
        Calendar calendar = new Calendar(CalendarId.of(command.getCalendarId()), command.getDate(), command.getAppointmentLimit());
        return calendar.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
