package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.Calendar;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.ChangeAppointmentDateCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CalendarId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class ChangeAppointmentDateUseCase implements UseCaseForCommand<ChangeAppointmentDateCommand> {

    private final EventsRepository eventsRepository;

    public ChangeAppointmentDateUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeAppointmentDateCommand command) {

        List<DomainEvent> calendarEvents = eventsRepository.findByAggregatedRootId(command.getCalendarId());
        Calendar calendar = Calendar.from(CalendarId.of(command.getCalendarId()), calendarEvents);
        calendar.ChangeAppointmentDate(command.getAppointmentId(), command.getDate());
        return calendar.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
