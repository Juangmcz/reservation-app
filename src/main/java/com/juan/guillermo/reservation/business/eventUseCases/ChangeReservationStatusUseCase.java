package com.juan.guillermo.reservation.business.eventUseCases;

import com.juan.guillermo.reservation.business.commons.EventsRepository;
import com.juan.guillermo.reservation.business.commons.UseCaseForEvent;
import com.juan.guillermo.reservation.domain.calendaraggregate.events.AppointmentStatusChanged;
import com.juan.guillermo.reservation.domain.reservationaggregate.Reservation;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.ReservationId;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public class ChangeReservationStatusUseCase implements UseCaseForEvent<AppointmentStatusChanged> {

    private final EventsRepository eventsRepository;

    public ChangeReservationStatusUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AppointmentStatusChanged event) {

        List<DomainEvent> reservationEvents = eventsRepository.findByAggregatedRootId(event.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(event.getReservationId()), reservationEvents);
        reservation.ChangeStatus(event.getReservationId(), event.getStatus());
        return reservation.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
