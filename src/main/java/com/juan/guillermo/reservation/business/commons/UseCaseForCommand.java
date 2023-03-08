package com.juan.guillermo.reservation.business.commons;


import com.juan.guillermo.reservation.generic.Command;
import com.juan.guillermo.reservation.generic.DomainEvent;

import java.util.List;

public interface UseCaseForCommand <T extends Command> {

    List<DomainEvent> apply(T command);

}
