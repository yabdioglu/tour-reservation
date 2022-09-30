package com.yabdioglu.tourreservation.tour;

import com.yabdioglu.tourreservation.shared.GenericResponse;
import com.yabdioglu.tourreservation.tour.vm.TourRequest;
import com.yabdioglu.tourreservation.tour.vm.TourResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/1.0")
public class TourController {
    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping("/tours")
    public GenericResponse createTour(@ModelAttribute TourRequest tourRequest, @RequestParam MultipartFile multipartFile) throws IOException {
        tourService.createTour(tourRequest, multipartFile);
        return new GenericResponse("tour created");
    }

    @GetMapping("/tours")
    public Page<TourResponse> getAllTours(Pageable pageable) {
        return tourService.getAllTours(pageable).map(TourResponse::new);
    }

    @GetMapping("/tours/{id}")
    public TourResponse getById(@PathVariable Long id) {
        return new TourResponse(tourService.getById(id));
    }

}
