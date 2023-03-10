package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.Calendar;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.ScheduleAppointmentCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CalendarId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class ScheduleAppointmentUseCase implements UseCaseForCommand<ScheduleAppointmentCommand> {

    private final EventsRepository eventsRepository;

    public ScheduleAppointmentUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ScheduleAppointmentCommand command) {
        List<DomainEvent> calendarEvents = eventsRepository.findByAggregatedRootId(command.getCalendarId());
        Calendar calendar = Calendar.from(CalendarId.of(command.getCalendarId()), calendarEvents);
        calendar.ScheduleAppointment(
                command.getAppointmentId(),
                command.getReservationId(),
                command.getDetailId(),
                command.getDate(),
                command.getComment(),
                command.getZoneId(),
                command.getName(),
                command.getType()
        );
        return calendar.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}