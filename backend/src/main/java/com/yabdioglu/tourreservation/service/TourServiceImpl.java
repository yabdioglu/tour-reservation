package com.yabdioglu.tourreservation.service;

import com.yabdioglu.tourreservation.dao.TourRepository;
import com.yabdioglu.tourreservation.entity.Tour;
import com.yabdioglu.tourreservation.error.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
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
