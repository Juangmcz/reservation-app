package com.juan.guillermo.reservation.business.calendar;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.domain.calendaraggregate.commands.CreateCalendarCommand;
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

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreateCalendarUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateCalendarUseCase createCalendarUseCase;

    @BeforeEach
    void setup(){
        createCalendarUseCase = new CreateCalendarUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreateCalendarCommand createCalendarCommand = new CreateCalendarCommand("calendarId", "3/10/2023", 10);

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(CalendarCreated.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });
        List<DomainEvent> domainEventList = createCalendarUseCase.apply(createCalendarCommand);

        Assertions.assertEquals(1,domainEventList.size());
        Assertions.assertEquals("calendarId",domainEventList.get(0).aggregateRootId());
        Assertions.assertEquals(10, ((CalendarCreated)domainEventList.get(0)).getAppointmentLimit());
        Assertions.assertEquals("3/10/2023", ((CalendarCreated)domainEventList.get(0)).getDate());
    }
}