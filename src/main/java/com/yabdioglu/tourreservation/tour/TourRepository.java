package com.yabdioglu.tourreservation.tour;

import com.yabdioglu.tourreservation.tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

}
