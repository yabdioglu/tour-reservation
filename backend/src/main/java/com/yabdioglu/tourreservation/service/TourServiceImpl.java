package com.yabdioglu.tourreservation.service;

import com.yabdioglu.tourreservation.dao.TourRepository;
import com.yabdioglu.tourreservation.dto.TourRequest;
import com.yabdioglu.tourreservation.entity.Tour;
import com.yabdioglu.tourreservation.error.NotFoundException;
import com.yabdioglu.tourreservation.util.FileUploadUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private FileUploadUtil fileUploadUtil;

    public TourServiceImpl(TourRepository tourRepository, FileUploadUtil fileUploadUtil) {
        this.tourRepository = tourRepository;
        this.fileUploadUtil = fileUploadUtil;
    }

    public Tour saveTour(TourRequest tourRequest) throws IOException {
        Tour tour = new Tour();
        tour.setImageUrl(fileUploadUtil.saveFile(tourRequest.getMultipartFile()));
        tour.setTitle(tourRequest.getTitle());
        tour.setDescription(tourRequest.getDescription());
        tour.setPriceForAdult(tourRequest.getPriceForAdult());
        tour.setPriceForChild(tourRequest.getPriceForChild());
        tour.setQuota(tourRequest.getQuota());
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
}
