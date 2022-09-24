package com.yabdioglu.tourreservation.dao;

import com.yabdioglu.tourreservation.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

}
