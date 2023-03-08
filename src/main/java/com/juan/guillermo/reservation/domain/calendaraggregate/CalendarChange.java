package com.juan.guillermo.reservation.domain.calendaraggregate;

import com.juan.guillermo.reservation.domain.calendaraggregate.events.CalendarCreated;
import com.juan.guillermo.reservation.generic.EventChange;

import java.util.ArrayList;

public class CalendarChange extends EventChange {

    public CalendarChange(Calendar calendar){

        apply((CalendarCreated event) -> calendar.appointments = new ArrayList<>());

    }


}
