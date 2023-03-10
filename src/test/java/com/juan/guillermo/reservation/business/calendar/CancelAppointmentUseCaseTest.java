package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.CancelAppointmentCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.CreateCalendarCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.ScheduleAppointmentCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.events.AppointmentScheduled;
import com.juan.guillermo.reservation.domain.calendaraggregate.events.CalendarCreated;
import com.juan.guillermo.reservation.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class CancelAppointmentUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CancelAppointmentUseCase cancelAppointmentUseCase;

    @BeforeEach
    void setup() {
        cancelAppointmentUseCase = new CancelAppointmentUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        List<DomainEvent> mockedEvents = new ArrayList<>();

        CalendarCreated calendarCreated = new CalendarCreated("3/10/2023", 10);
        calendarCreated.setAggregateRootId("calendarId");
        mockedEvents.add(calendarCreated);

        AppointmentScheduled appointmentScheduled = new AppointmentScheduled(
                "appointmentId",
                "reservationId",
                "detailId",
                "03/09/2023",
                "N/A",
                "ZoneId",
                "Brushing Room",
                "Brush"
        );
        appointmentScheduled.setAggregateRootId("calendarId");
        mockedEvents.add(appointmentScheduled);

        CancelAppointmentCommand cancelAppointmentCommand = new CancelAppointmentCommand("calendarId", "appointmentId");

        Mockito.when(eventsRepository.findByAggregatedRootId(ArgumentMatchers.any(String.class)))
                .thenReturn(mockedEvents);

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer( invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = cancelAppointmentUseCase.apply(cancelAppointmentCommand);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("munoz.juan.appointmentCancelled", domainEventList.get(0).type);
    }
}