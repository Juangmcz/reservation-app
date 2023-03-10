package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.Reservation;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.ChangeCustomerCellCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class ChangeCustomerCellUseCase implements UseCaseForCommand<ChangeCustomerCellCommand> {

    private final EventsRepository eventsRepository;

    public ChangeCustomerCellUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeCustomerCellCommand command) {

        List<DomainEvent> reservationEvents = eventsRepository.findByAggregatedRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.ChangeCustomerCell(command.getCustomerId(), command.getCell());
        return reservation.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
