package com.juan.guillermo.reservation.domain.reservationaggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCustomerCellCommand extends Command {

    private String reservationId;
    private String customerId;
    private String cell;

    public ChangeCustomerCellCommand(){}

    public ChangeCustomerCellCommand(String reservationId, String customerId, String cell) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.cell = cell;
    }
}
