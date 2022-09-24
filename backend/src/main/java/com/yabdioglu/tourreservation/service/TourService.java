package com.yabdioglu.tourreservation.service;

import com.yabdioglu.tourreservation.entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TourService {

    Tour getById(Long id);

    Page<Tour> getAllTours(Pageable pageable);
}
