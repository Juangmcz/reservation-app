package com.juan.guillermo.reservation.domain.reservationaggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSuffixChanged extends DomainEvent {

    private String customerId;
    private String suffix;

    public CustomerSuffixChanged() {
        super("munoz.juan.customerSuffixChanged");
    }

    public CustomerSuffixChanged(String customerId, String suffix) {
        super("munoz.juan.customerSuffixChanged");
        this.customerId = customerId;
        this.suffix = suffix;
    }
}
