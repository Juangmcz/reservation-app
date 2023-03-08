package com.juan.guillermo.reservation.business.commons;

import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public interface UseCaseForEvent <T extends DomainEvent> {

    List<DomainEvent> apply(T domainEvent);

}
