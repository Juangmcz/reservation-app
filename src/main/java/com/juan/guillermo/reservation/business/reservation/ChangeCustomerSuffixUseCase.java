package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.Reservation;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.ChangeCustomerSuffixCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class ChangeCustomerSuffixUseCase implements UseCaseForCommand<ChangeCustomerSuffixCommand> {

    private final EventsRepository eventsRepository;

    public ChangeCustomerSuffixUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeCustomerSuffixCommand command) {

        List<DomainEvent> reservationEvents = eventsRepository.findByAggregatedRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.ChangeCustomerSuffix(command.getCustomerId(), command.getSuffix());
        return reservation.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
