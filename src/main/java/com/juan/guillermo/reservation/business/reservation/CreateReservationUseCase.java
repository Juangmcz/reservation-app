package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.Reservation;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.CreateReservationCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateReservationUseCase implements UseCaseForCommand<CreateReservationCommand> {

    private final EventsRepository eventsRepository;

    public CreateReservationUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateReservationCommand command) {
        Reservation reservation = new Reservation(ReservationId.of(command.getReservationId()),
                command.getDate(),
                command.getComment(),
                command.getCustomerFirstName(),
                command.getCustomerLastName(),
                command.getCustomerCell(),
                command.getSuffix(),
                command.getHairStylistFirstName(),
                command.getHairStylistLastName(),
                command.getHairStylistCell(),
                command.getSpeciality()
        );
        return reservation.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
