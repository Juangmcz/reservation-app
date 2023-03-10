package com.juan.guillermo.reservation.domain.reservationaggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HairStylistChanged extends DomainEvent {

    private String hairStylistId;
    private String hairStylistFirstName;
    private String hairStylistLastName;
    private String hairStylistCell;
    private String speciality;

    public HairStylistChanged() {
        super("munoz.juan.hairStylistChanged");
    }

    public HairStylistChanged(
            String hairStylistId,
            String hairStylistFirstName,
            String hairStylistLastName,
            String hairStylistCell,
            String speciality
    ) {
        super("munoz.juan.hairStylistChanged");
        this.hairStylistId = hairStylistId;
        this.hairStylistFirstName = hairStylistFirstName;
        this.hairStylistLastName = hairStylistLastName;
        this.hairStylistCell = hairStylistCell;
        this.speciality = speciality;
    }

}
