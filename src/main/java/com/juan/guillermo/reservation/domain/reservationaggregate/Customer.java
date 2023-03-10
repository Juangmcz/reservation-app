package com.juan.guillermo.reservation.domain.reservationaggregate;

import com.juan.guillermo.reservation.domain.reservationaggregate.values.*;
import com.juan.guillermo.reservation.generic.Entity;

public class Customer extends Entity<CustomerId> {

    private FullName fullName;
    private Cell cell;
    private Suffix suffix;

    public Customer(CustomerId customerId, FullName fullName, Cell cell, Suffix suffix) {
        super(customerId);
        this.fullName = fullName;
        this.cell = cell;
        this.suffix = suffix;
    }

    public FullName fullName() {
        return fullName;
    }

    public Cell cell() {
        return cell;
    }

    public Suffix suffix() {
        return suffix;
    }

    public void ChangeCell(String cell) {
        this.cell = new Cell(cell);
    }

    public void ChangeSuffix(String suffix) {
        this.suffix = new Suffix(suffix);
    }
}
