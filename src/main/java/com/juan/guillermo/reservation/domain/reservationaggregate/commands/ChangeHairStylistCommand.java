package com.juan.guillermo.reservation.domain.reservationaggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeHairStylistCommand extends Command {
    private String reservationId;
    private String hairStylistId;
    private String hairStylistFirstName;
    private String hairStylistLastName;
    private String hairStylistCell;
    private String speciality;

    public ChangeHairStylistCommand(){}

    public ChangeHairStylistCommand(
            String reservationId,
            String hairStylistId,
            String hairStylistFirstName,
            String hairStylistLastName,
            String hairStylistCell,
            String speciality
    ) {
        this.reservationId = reservationId;
        this.hairStylistId = hairStylistId;
        this.hairStylistFirstName = hairStylistFirstName;
        this.hairStylistLastName = hairStylistLastName;
        this.hairStylistCell = hairStylistCell;
        this.speciality = speciality;
    }
}
