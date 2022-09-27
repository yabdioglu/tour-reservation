package com.yabdioglu.tourreservation.reservation;

import com.yabdioglu.tourreservation.reservation.vm.ReservationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationService {

    Reservation createReservation(ReservationRequest reservationRequest);
    Page<Reservation> getAllReservations(Pageable pageable);

    Reservation getById(Long id);

    Page<Reservation> getByUserId(Long userId, Pageable pageable);


}
