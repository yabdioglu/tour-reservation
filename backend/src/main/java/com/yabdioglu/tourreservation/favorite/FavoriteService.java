package com.yabdioglu.tourreservation.favorite;

import com.yabdioglu.tourreservation.favorite.vm.FavoriteRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteService {

    Page<Favorite> findByUserId(Long userId, Pageable pageable);

    void addFavorite(FavoriteRequest favoriteRequest);
}
