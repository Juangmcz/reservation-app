package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.Calendar;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.ChangeAppointmentStatusCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CalendarId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class ChangeAppointmentStatusUseCase implements UseCaseForCommand<ChangeAppointmentStatusCommand> {

    private final EventsRepository eventsRepository;

    public ChangeAppointmentStatusUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeAppointmentStatusCommand command) {

        List<DomainEvent> calendarEvents = eventsRepository.findByAggregatedRootId(command.getCalendarId());
        Calendar calendar = Calendar.from(CalendarId.of(command.getCalendarId()), calendarEvents);
        calendar.ChangeAppointmentStatus(command.getAppointmentId(), command.getReservationId(), command.getStatus());
        return calendar.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
