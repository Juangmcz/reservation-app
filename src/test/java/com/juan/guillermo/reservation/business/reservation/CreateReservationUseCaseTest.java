package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.CreateReservationCommand;
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

import java.util.List;


@ExtendWith(MockitoExtension.class)
class CreateReservationUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateReservationUseCase createReservationUseCase;

    @BeforeEach
    void setup() {
        createReservationUseCase = new CreateReservationUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        CreateReservationCommand createReservationCommand = new CreateReservationCommand(
                "reservationId",
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

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(ReservationCreated.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> domainEventList = createReservationUseCase.apply(createReservationCommand);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("reservationId", domainEventList.get(0).aggregateRootId());
        Assertions.assertEquals("03/08/2023", ((ReservationCreated)domainEventList.get(0)).getDate());
        Assertions.assertEquals("3115956841", ((ReservationCreated)domainEventList.get(0)).getCustomerCell());
    }
}