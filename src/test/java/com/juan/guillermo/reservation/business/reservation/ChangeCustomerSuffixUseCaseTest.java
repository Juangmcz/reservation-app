package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.ChangeCustomerCellCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.ChangeCustomerSuffixCommand;
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
class ChangeCustomerSuffixUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ChangeCustomerSuffixUseCase changeCustomerSuffixUseCase;

    @BeforeEach
    void setUp() {changeCustomerSuffixUseCase = new ChangeCustomerSuffixUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

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

        ChangeCustomerSuffixCommand changeCustomerSuffixCommand = new ChangeCustomerSuffixCommand("reservationId", "customerId", "Sr.");

        Mockito.when(eventsRepository.findByAggregatedRootId(ArgumentMatchers.any(String.class)))
                .thenReturn(mockedEvents);

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer( invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = changeCustomerSuffixUseCase.apply(changeCustomerSuffixCommand);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("munoz.juan.customerSuffixChanged", domainEventList.get(0).type);
    }
}