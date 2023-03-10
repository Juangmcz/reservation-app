package com.juan.guillermo.reservation.business.eventUseCases;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.domain.calendaraggregate.events.CustomerAnnounced;
import com.juan.guillermo.reservation.domain.reservationaggregate.events.ReservationCreated;
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
class FulFillReservationUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private FulFillReservationUseCase fulFillReservationUseCase;

    @BeforeEach
    void setup() {
        fulFillReservationUseCase = new FulFillReservationUseCase(eventsRepository);}

    @Test
    void successfulScenario() {

        List<DomainEvent> mockedEvents = new ArrayList<>();

        ReservationCreated reservationCreated = new ReservationCreated(
                "03/08/2023",
                "N/A",
                "Juan Guillermo",
                "Munoz Correa",
                "3115956841",
                "Jr.",
                "Jose",
                "Gomez",
                "3125859475",
                "Long Hair"
        );
        reservationCreated.setAggregateRootId("reservationId");
        mockedEvents.add(reservationCreated);

        CustomerAnnounced customerAnnounced = new CustomerAnnounced("reservationId","appointmentId" );

        Mockito.when(eventsRepository.findByAggregatedRootId(ArgumentMatchers.any(String.class)))
                .thenReturn(mockedEvents);

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer( invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = fulFillReservationUseCase.apply(customerAnnounced);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("munoz.juan.reservationFullFilled", domainEventList.get(0).type);

    }
}