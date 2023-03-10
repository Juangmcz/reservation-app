package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.Calendar;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.AnnounceCustomerCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.CalendarId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class AnnounceCustomerUseCase implements UseCaseForCommand<AnnounceCustomerCommand> {

    private final EventsRepository eventsRepository;

    public AnnounceCustomerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AnnounceCustomerCommand command) {

        List<DomainEvent> calendarEvents = eventsRepository.findByAggregatedRootId(command.getCalendarId());
        Calendar calendar = Calendar.from(CalendarId.of(command.getCalendarId()), calendarEvents);
        calendar.AnnounceCustomer(command.getReservationId(), command.getAppointmentId());
        return calendar.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
