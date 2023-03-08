package com.juan.guillermo.reservation.domain.reservationaggregate.values;

import com.juan.guillermo.reservation.generic.ValueObject;

public class FullName implements ValueObject<FullName.Props> {

    private String firstName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Props value() {
        return new Props(){

            @Override
            public String firstName() {
                return firstName;
            }

            @Override
            public String lastName() {
                return lastName;
            }
        };
    }

    interface Props {
        String firstName();
        String lastName();
    }
}
