package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.ChangeAppointmentDateCommand;
import com.juan.guillermo.reservation.domain.calendaraggregate.events.AppointmentDateChanged;
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
class ChangeAppointmentDateUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ChangeAppointmentDateUseCase changeAppointmentDateUseCase;

    @BeforeEach
    void setUp() {changeAppointmentDateUseCase = new ChangeAppointmentDateUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

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

        mockedEvents.add(appointmentScheduled);

        ChangeAppointmentDateCommand changeAppointmentDateCommand = new ChangeAppointmentDateCommand("calendarId","appointmentId","03/24/2023");

        Mockito.when(eventsRepository.findByAggregatedRootId(ArgumentMatchers.any(String.class)))
                .thenReturn(mockedEvents);

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer( invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = changeAppointmentDateUseCase.apply(changeAppointmentDateCommand);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("munoz.juan.appointmentDateChanged", domainEventList.get(0).type);
        Assertions.assertEquals("03/24/2023", ((AppointmentDateChanged)domainEventList.get(0)).getDate());
    }
}