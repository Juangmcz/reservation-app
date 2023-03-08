package com.juan.guillermo.reservation.business.commons;

import com.juan.guillermo.reservation.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventsRepository {
    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findByAggregatedRootId(String aggregatedRootId);
}