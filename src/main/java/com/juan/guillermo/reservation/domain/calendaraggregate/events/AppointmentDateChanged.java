package com.juan.guillermo.reservation.domain.calendaraggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDateChanged extends DomainEvent {

    private String appointmentId;
    private String date;

    public AppointmentDateChanged(){
        super("munoz.juan.appointmentDateChanged");
    }

    public AppointmentDateChanged(String appointmentId, String date){
        super("munoz.juan.appointmentDateChanged");
        this.appointmentId = appointmentId;
        this.date = date;
    }
}
