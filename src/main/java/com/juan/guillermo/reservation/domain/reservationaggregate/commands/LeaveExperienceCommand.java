package com.juan.guillermo.reservation.domain.reservationaggregate.commands;

import com.juan.guillermo.reservation.generic.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveExperienceCommand extends Command {

    private String reservationId;
    private String experienceId;
    private double rating;
    private String feedback;

    public LeaveExperienceCommand(){}

    public LeaveExperienceCommand(String reservationId, String experienceId, double rating, String feedback) {
        this.reservationId = reservationId;
        this.experienceId = experienceId;
        this.rating = rating;
        this.feedback = feedback;
    }
}
