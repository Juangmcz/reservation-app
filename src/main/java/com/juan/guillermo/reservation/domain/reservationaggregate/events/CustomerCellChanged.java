package com.juan.guillermo.reservation.domain.reservationaggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCellChanged extends DomainEvent {

    private String customerId;
    private String cell;

    public CustomerCellChanged() {
        super("munoz.juan.customerCellChanged");
    }

    public CustomerCellChanged(String customerId, String cell) {
        super("munoz.juan.customerCellChanged");
        this.customerId = customerId;
        this.cell = cell;
    }
}
