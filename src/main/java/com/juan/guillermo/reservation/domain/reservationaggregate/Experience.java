package com.juan.guillermo.reservation.domain.reservationaggregate;

import com.juan.guillermo.reservation.domain.reservationaggregate.values.*;
import com.juan.guillermo.reservation.generic.Entity;

public class Experience extends Entity<ExperienceId> {

    private LastUpdated lastUpdated;
    private Rating rating;
    private FeedBack feedBack;

    public Experience(ExperienceId experienceId, Rating rating, FeedBack feedBack) {
        super(experienceId);
        this.lastUpdated = new LastUpdated();
        this.rating = rating;
        this.feedBack = feedBack;
    }

    public LastUpdated lastUpdated() {
        return lastUpdated;
    }

    public Rating rating() {
        return rating;
    }

    public FeedBack feedBack() {
        return feedBack;
    }

}
