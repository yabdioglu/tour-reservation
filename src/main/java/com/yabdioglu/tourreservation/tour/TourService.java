package com.yabdioglu.tourreservation.tour;

import com.yabdioglu.tourreservation.tour.vm.TourRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface TourService {

    Tour createTour(TourRequest tourRequest) throws IOException;
    Tour getById(Long id);

    Page<Tour> getAllTours(Pageable pageable);
}
