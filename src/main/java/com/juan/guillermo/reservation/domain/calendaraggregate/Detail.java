package com.juan.guillermo.reservation.domain.calendaraggregate;

import com.juan.guillermo.reservation.domain.calendaraggregate.values.Comment;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.DetailId;
import com.juan.guillermo.reservation.domain.calendaraggregate.values.LastUpdated;
import com.juan.guillermo.reservation.generic.Entity;

public class Detail extends Entity<DetailId> {

    private LastUpdated lastUpdated;
    private Comment comment;

    public Detail(DetailId detailId, Comment comment) {
        super(detailId);
        this.lastUpdated = new LastUpdated();
        this.comment = comment;
    }

    public LastUpdated lastUpdated(){
        return lastUpdated;
    }

    public Comment comment(){
        return comment;
    }
}
