package com.yabdioglu.tourreservation.tour;

import com.yabdioglu.tourreservation.error.NotFoundException;
import com.yabdioglu.tourreservation.shared.GenericResponse;
import com.yabdioglu.tourreservation.shared.cloudinary.CloudinaryService;
import com.yabdioglu.tourreservation.tour.vm.TourRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    private CloudinaryService cloudinaryService;

    public TourServiceImpl(TourRepository tourRepository, CloudinaryService cloudinaryService) {
        this.tourRepository = tourRepository;
        this.cloudinaryService = cloudinaryService;
    }

    public Tour createTour(TourRequest tourRequest, MultipartFile multipartFile) throws IOException {
        Tour tour = new Tour();
        String url = cloudinaryService.uploadFile(multipartFile);
        convertToTour(tourRequest, tour, url);
        return tourRepository.save(tour);
    }

    @Override
    public Tour getById(Long id) {
        Tour tour = tourRepository.findById(id).orElse(null);
        if(tour == null) {
            throw new NotFoundException();
        }
        return tour;
    }

    @Override
    public Page<Tour> getAllTours(Pageable pageable) {
        return tourRepository.findAll(pageable);
    }

    @Override
    public Page<Tour> findByTitleContaining(String title, Pageable pageable) {
        return tourRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    public void deleteById(Long id) {
        tourRepository.deleteById(id);
    }

    private void convertToTour(TourRequest tourRequest, Tour tour, String url) throws IOException {
        tour.setImageUrl(url);
        tour.setTitle(tourRequest.getTitle());
        tour.setDescription(tourRequest.getDescription());
        tour.setPriceForAdult(tourRequest.getPriceForAdult());
        tour.setPriceForChild(tourRequest.getPriceForChild());
        tour.setQuota(tourRequest.getQuota());
    }
}
