package com.yabdioglu.tourreservation.favorite;

import com.yabdioglu.tourreservation.favorite.vm.FavoriteRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

public interface FavoriteService {

    Page<Favorite> findByUserId(Long userId, Pageable pageable);

    void addFavorite(FavoriteRequest favoriteRequest);

    void delete(Long id);
}
