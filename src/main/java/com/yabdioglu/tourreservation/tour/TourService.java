package com.yabdioglu.tourreservation.tour;

import com.yabdioglu.tourreservation.tour.vm.TourRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TourService {

    Tour createTour(TourRequest tourRequest, MultipartFile multipartFile) throws IOException;
    Tour getById(Long id);
    Page<Tour> getAllTours(Pageable pageable);
    Page<Tour> findByTitleContaining(String title, Pageable pageable);
}
