package com.gerwld.reservation_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/api/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(
            @PathVariable("id") Long id
            ) {
        log.info("Called getReservationById, id: "+id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.getReservationById(id));
    }

    @GetMapping("/api/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        log.info("Called getAllReservations");
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.findAllReservations());
    }

    @PostMapping("/api/reservations")
    public ResponseEntity<Reservation> createReservation(
          @RequestBody Reservation reservationToCreate
    ) {
        log.info("Called createReservation");
       return ResponseEntity.status(HttpStatus.CREATED)
               .header("test-header", "123")
               .body(ReservationService.createReservation(reservationToCreate));
        // return ReservationService.createReservation(reservationToCreate);

    }
}
