package com.yabdioglu.tourreservation.favorite.vm;

import com.yabdioglu.tourreservation.favorite.Favorite;
import com.yabdioglu.tourreservation.tour.vm.TourResponse;
import lombok.Data;

@Data
public class FavoriteResponse {

    private Long id;

    private Long userId;

    private TourResponse tourResponse;

    public FavoriteResponse(Favorite favorite){
        this.id = favorite.getId();
        this.userId = favorite.getUser().getId();
        this.tourResponse = new TourResponse(favorite.getTour());
    }
}
