package com.yabdioglu.tourreservation.reservation;

import com.yabdioglu.tourreservation.reservation.vm.ReservationRequest;
import com.yabdioglu.tourreservation.reservation.vm.ReservationResponse;
import com.yabdioglu.tourreservation.reservation.vm.ReservationResponseWithUser;
import com.yabdioglu.tourreservation.shared.GenericResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0")
@CrossOrigin("https://tour-reservation-admin.herokuapp.com")
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
    // has admin
    public Page<ReservationResponseWithUser> getAllReservations(Pageable pageable) {
        return reservationService.getAllReservations(pageable).map(ReservationResponseWithUser::new);
    }

    @GetMapping("/reservations/{id}")
    public ReservationResponse getById(@PathVariable Long id){
        return new ReservationResponse(reservationService.getById(id));
    }

    @GetMapping("/users/{userId}/reservations")
    public Page<ReservationResponse> getByUserId(@PathVariable Long userId, Pageable pageable){
        return reservationService.getByUserId(userId, pageable).map(ReservationResponse::new);
    }

    @PostMapping("/reservations/cancel/{id}")
    public ReservationResponse cancelReservation(@PathVariable long id) {
        return new ReservationResponse(reservationService.cancelReservation(id));
    }

}
