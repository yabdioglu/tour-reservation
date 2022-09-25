package com.yabdioglu.tourreservation.controller;

import com.yabdioglu.tourreservation.dto.TourRequest;
import com.yabdioglu.tourreservation.entity.Tour;
import com.yabdioglu.tourreservation.service.TourService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/1.0")
public class TourController {
    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping("/tours")
    public Tour saveTour(@ModelAttribute TourRequest tourRequest) throws IOException {
        return tourService.saveTour(tourRequest);
    }

    @GetMapping("/tours")
    public Page<Tour> getById(Pageable pageable) {
        return tourService.getAllTours(pageable);
    }

    @GetMapping("/tours/{id}")
    public Tour getById(@PathVariable Long id) {
        return tourService.getById(id);
    }

}
