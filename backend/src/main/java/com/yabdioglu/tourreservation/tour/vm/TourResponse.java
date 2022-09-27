package com.yabdioglu.tourreservation.tour.vm;

import com.yabdioglu.tourreservation.tour.Tour;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TourResponse {

    private Long id;

    private String imageUrl;

    private String description;

    private BigDecimal priceForAdult;

    private BigDecimal priceForChild;

    private int quota;

    private boolean bestTour;

    private boolean active;

    private boolean quotaActive;

    private Date dateCreated;

    public TourResponse(Tour tour) {
        this.id = tour.getId();
        this.imageUrl = tour.getImageUrl();
        this.description = tour.getDescription();
        this.priceForAdult = tour.getPriceForAdult();
        this.priceForChild = tour.getPriceForChild();
        this.quota = tour.getQuota();
        this.bestTour = tour.isBestTour();
        this.active = tour.isActive();
        this.quotaActive = tour.isQuotaActive();
        this.dateCreated = tour.getDateCreated();
    }
}
