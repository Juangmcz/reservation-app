package com.juan.guillermo.reservation.business.eventUseCases;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForEvent;
import com.juan.guillermo.reservation.domain.calendaraggregate.events.CustomerAnnounced;
import com.juan.guillermo.reservation.domain.reservationaggregate.Reservation;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class FulFillReservationUseCase implements UseCaseForEvent<CustomerAnnounced> {

    private final EventsRepository eventsRepository;

    public FulFillReservationUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(CustomerAnnounced event) {

        List<DomainEvent> reservationEvents = eventsRepository.findByAggregatedRootId(event.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(event.getReservationId()), reservationEvents);
        reservation.FulFillReservation(event.getReservationId());
        return reservation.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
