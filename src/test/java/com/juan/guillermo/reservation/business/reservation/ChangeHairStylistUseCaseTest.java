package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.ChangeHairStylistCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.events.HairStylistChanged;
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
class ChangeHairStylistUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ChangeHairStylistUseCase changeHairStylistUseCase;

    @BeforeEach
    void setUp() {changeHairStylistUseCase = new ChangeHairStylistUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

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

        List<DomainEvent> mocksEvents = new ArrayList<>();
        mocksEvents.add(reservationCreated);

        ChangeHairStylistCommand changeHairStylistCommand = new ChangeHairStylistCommand(
                "reservationId",
                "hairStylistId",
                "Carlos",
                "Franco",
                "3295854714",
                "Short Hair"
        );

        Mockito.when(eventsRepository.findByAggregatedRootId("reservationId"))
                .thenAnswer(invocationOnMock -> {
                    return mocksEvents;
                });

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(HairStylistChanged.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> domainEventList = changeHairStylistUseCase.apply(changeHairStylistCommand);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("munoz.juan.hairStylistChanged", domainEventList.get(0).type);
    }
}