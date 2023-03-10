package com.juan.guillermo.reservation.business.calendar;


import com.juan.guillermo.reservation.business.commons.EventsRepository;
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
class ScheduleAppointmentUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ScheduleAppointmentUseCase scheduleAppointmentUseCase;

    @BeforeEach
    void setup() {
        scheduleAppointmentUseCase = new ScheduleAppointmentUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        ScheduleAppointmentCommand scheduleAppointmentCommand = new ScheduleAppointmentCommand(
                "calendarId",
                "appointmentId",
                "reservationId",
                "detailId",
                "03/09/2023",
                "N/A",
                "ZoneId",
                "Brushing Room",
                "Brush"
        );

        List<DomainEvent> calendarEvents = new ArrayList<>();
        calendarEvents.add(new CalendarCreated());

        Mockito.when(eventsRepository.findByAggregatedRootId(ArgumentMatchers.any(String.class)))
                .thenReturn(calendarEvents);

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer( invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = scheduleAppointmentUseCase.apply(scheduleAppointmentCommand);

        Assertions.assertEquals(2, domainEventList.size());
        Assertions.assertTrue(domainEventList.size() > 1);
        Assertions.assertEquals("munoz.juan.appointmentScheduled", domainEventList.get(1).type);
        Assertions.assertEquals("AppointmentId",
                ((AppointmentScheduled) (domainEventList.get(domainEventList.size() - 1))).getAppointmentId());

    }
}