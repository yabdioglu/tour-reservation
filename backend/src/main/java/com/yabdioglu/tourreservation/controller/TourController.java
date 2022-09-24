package com.yabdioglu.tourreservation.controller;

import com.yabdioglu.tourreservation.entity.Tour;
import com.yabdioglu.tourreservation.service.TourService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0")
public class TourController {
    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
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
