package com.yabdioglu.tourreservation.service;

import com.yabdioglu.tourreservation.dto.TourRequest;
import com.yabdioglu.tourreservation.entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TourService {

    Tour saveTour(TourRequest tourRequest) throws IOException;
    Tour getById(Long id);

    Page<Tour> getAllTours(Pageable pageable);
}
