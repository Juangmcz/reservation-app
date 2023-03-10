package com.juan.guillermo.reservation.domain.reservationaggregate.events;

import com.juan.guillermo.reservation.generic.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienceLeaved extends DomainEvent {

    private String experienceId;
    private double rating;
    private String feedback;

    public ExperienceLeaved(String experienceId, double rating, String feedback) {
        super("munoz.juan.experienceLeaved");
        this.experienceId = experienceId;
        this.rating = rating;
        this.feedback = feedback;
    }
}
