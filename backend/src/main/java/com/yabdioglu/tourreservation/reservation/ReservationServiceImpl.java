package com.yabdioglu.tourreservation.reservation;

import com.yabdioglu.tourreservation.error.NotFoundException;
import com.yabdioglu.tourreservation.reservation.vm.ReservationRequest;
import com.yabdioglu.tourreservation.tour.TourService;
import com.yabdioglu.tourreservation.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    private ReservationRepository reservationRepository;
    private UserService userService;
    private TourService tourService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, TourService tourService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.tourService = tourService;
    }

    @Override
    public Reservation createReservation(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setUser(userService.findById(reservationRequest.getUserId()));
        reservation.setTour(tourService.getById(reservationRequest.getTourId()));
        reservation.setSelectDate(reservationRequest.getSelectDate());
        reservation.setAdult(reservationRequest.getAdult());
        reservation.setChild(reservationRequest.getChild());
        reservation.setHotelName(reservationRequest.getHotelName());
        reservation.setTotalPrice(reservationRequest.getTotalPrice());
        return reservationRepository.save(reservation);
    }

    @Override
    public Page<Reservation> getAllReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Reservation getById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if(reservation == null) {
            throw new NotFoundException();
        }
        return reservation;
    }

    @Override
    public Page<Reservation> getByUserId(Long userId, Pageable pageable) {
        return reservationRepository.findByUserId(userId, pageable);
    }
}
