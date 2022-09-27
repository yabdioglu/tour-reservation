package com.yabdioglu.tourreservation.reservation;

import com.yabdioglu.tourreservation.reservation.vm.ReservationRequest;
import com.yabdioglu.tourreservation.reservation.vm.ReservationResponse;
import com.yabdioglu.tourreservation.shared.GenericResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservations")
    public GenericResponse createReservation(@RequestBody ReservationRequest reservationRequest) {
        reservationService.createReservation(reservationRequest);
        return new GenericResponse("reservation created");
    }

    @GetMapping("/reservations")
    public Page<ReservationResponse> getAllReservations(Pageable pageable) {
        return reservationService.getAllReservations(pageable).map(ReservationResponse::new);
    }

    @GetMapping("/reservations/{id}")
    public ReservationResponse getById(@PathVariable Long id){
        return new ReservationResponse(reservationService.getById(id));
    }

    @GetMapping("/users/{userId}/reservations")
    public Page<ReservationResponse> getByUserId(@PathVariable Long userId, Pageable pageable){
        return reservationService.getByUserId(userId, pageable).map(ReservationResponse::new);
    }
}
