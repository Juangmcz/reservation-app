package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.Reservation;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.ChangeHairStylistCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.HairStylistId;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class ChangeHairStylistUseCase implements UseCaseForCommand<ChangeHairStylistCommand> {

    private final EventsRepository eventsRepository;

    public ChangeHairStylistUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeHairStylistCommand command) {
        List<DomainEvent> reservationEvents = eventsRepository.findByAggregatedRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.ChangeHairStylist(HairStylistId.of(command.getHairStylistId()),
                command.getHairStylistFirstName(),
                command.getHairStylistLastName(),
                command.getHairStylistCell(),
                command.getSpeciality()
        );
        return reservation.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}

