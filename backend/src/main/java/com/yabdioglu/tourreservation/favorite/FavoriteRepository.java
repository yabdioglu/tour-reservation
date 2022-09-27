package com.yabdioglu.tourreservation.favorite;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Page<Favorite> findByUserId(Long userId, Pageable pageable);
}
