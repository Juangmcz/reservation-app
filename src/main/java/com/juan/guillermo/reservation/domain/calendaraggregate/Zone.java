package com.juan.guillermo.reservation.domain.calendaraggregate;

import com.juan.guillermo.reservation.domain.calendaraggregate.values.IsAvailable;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.Name;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.Type;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.ZoneId;
import com.juan.guillermo.reservation.generic.Entity;

public class Zone extends Entity<ZoneId> {

    private Name name;
    private IsAvailable isAvailable;
    private Type type;

    public Zone(ZoneId zoneId, Name name, Type type) {
        super(zoneId);
        this.name = name;
        this.isAvailable = new IsAvailable(false);
        this.type = type;
    }

    public Name name(){
        return name;
    }

    public IsAvailable isAvailable(){
        return isAvailable;
    }

    public Type type(){
        return type;
    }

}
