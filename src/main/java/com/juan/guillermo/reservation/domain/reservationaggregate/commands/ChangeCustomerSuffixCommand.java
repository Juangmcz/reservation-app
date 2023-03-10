package com.juan.guillermo.reservation.domain.reservationaggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCustomerSuffixCommand extends Command {

    private String reservationId;
    private String customerId;
    private String suffix;

    public ChangeCustomerSuffixCommand(){}

    public ChangeCustomerSuffixCommand(String reservationId, String customerId, String suffix) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.suffix = suffix;
    }
}
