package com.juan.guillermo.reservation.domain.reservationaggregate;

import com.juan.guillermo.reservation.domain.reservationaggregate.values.Cell;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.FullName;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.HairStylistId;
import com.juan.guillermo.reservation.domain.reservationaggregate.values.Speciality;
import com.juan.guillermo.reservation.generic.Entity;

public class HairStylist extends Entity<HairStylistId> {

    private FullName fullName;
    private Cell cell;
    private Speciality speciality;

    public HairStylist(HairStylistId hairStylistId, FullName fullName, Cell cell, Speciality speciality) {
        super(hairStylistId);
        this.fullName = fullName;
        this.cell = cell;
        this.speciality = speciality;
    }

    public FullName fullName() {
        return fullName;
    }

    public Cell cell() {
        return cell;
    }

    public Speciality speciality() {
        return speciality;
    }
}
