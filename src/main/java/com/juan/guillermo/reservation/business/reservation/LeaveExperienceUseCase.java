package com.juan.guillermo.reservation.business.reservation;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.Reservation;
import com.juan.guillermo.reservation.domain.reservationaggregate.commands.LeaveExperienceCommand;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class LeaveExperienceUseCase implements UseCaseForCommand<LeaveExperienceCommand> {

    private final EventsRepository eventsRepository;

    public LeaveExperienceUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(LeaveExperienceCommand command) {

        List<DomainEvent> reservationEvents = eventsRepository.findByAggregatedRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.LeaveExperience(command.getExperienceId(), command.getRating(), command.getFeedback());
        return reservation.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
