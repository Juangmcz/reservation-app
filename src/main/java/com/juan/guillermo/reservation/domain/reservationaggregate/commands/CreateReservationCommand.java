package com.juan.guillermo.reservation.domain.reservationaggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReservationCommand extends Command {

    private String reservationId;
    private String date;
    private String comment;
    private String customerFirstName;
    private String customerLastName;
    private String customerCell;
    private String suffix;
    private String hairStylistFirstName;
    private String hairStylistLastName;
    private String hairStylistCell;
    private String speciality;

    public CreateReservationCommand() {}

    public CreateReservationCommand(
        String reservationId,
        String date,
        String comment,
        String customerFirstName,
        String customerLastName,
        String customerCell,
        String suffix,
        String hairStylistFirstName,
        String hairStylistLastName,
        String hairStylistCell,
        String speciality
    ) {
        this.reservationId = reservationId;
        this.date = date;
        this.comment = comment;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCell = customerCell;
        this.suffix = suffix;
        this.hairStylistFirstName = hairStylistFirstName;
        this.hairStylistLastName = hairStylistLastName;
        this.hairStylistCell = hairStylistCell;
        this.speciality = speciality;
    }
}
