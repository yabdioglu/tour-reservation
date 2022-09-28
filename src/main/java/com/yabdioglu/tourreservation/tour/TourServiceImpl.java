package com.yabdioglu.tourreservation.tour;

import com.yabdioglu.tourreservation.error.NotFoundException;
import com.yabdioglu.tourreservation.tour.vm.TourRequest;
import com.yabdioglu.tourreservation.shared.FileUploadUtil;
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

    public Tour createTour(TourRequest tourRequest, MultipartFile multipartFile) throws IOException {
        Tour tour = new Tour();
        convertToTour(tourRequest, tour, multipartFile);
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

    private void convertToTour(TourRequest tourRequest, Tour tour, MultipartFile multipartFile) throws IOException {
        tour.setImageUrl(fileUploadUtil.saveFile(multipartFile));
        tour.setTitle(tourRequest.getTitle());
        tour.setDescription(tourRequest.getDescription());
        tour.setPriceForAdult(tourRequest.getPriceForAdult());
        tour.setPriceForChild(tourRequest.getPriceForChild());
        tour.setQuota(tourRequest.getQuota());
    }
}
