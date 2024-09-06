package ftn.devops.accommodation.controller;

import ftn.devops.accommodation.dto.ReservationDTO;
import ftn.devops.accommodation.entity.Reservation;
import ftn.devops.accommodation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/addReservation")
    public ResponseEntity<Boolean>  addReservation(@RequestBody ReservationDTO reservation){
        boolean ret = reservationService.addReservation(reservation);
        return ResponseEntity.ok().body(ret);
    }

    @GetMapping(value = "/allReservations")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        return ResponseEntity.ok().body(reservationService.getAllReservations());
    }

    @PostMapping(value = "/confirmReservation")
    public ResponseEntity<Boolean>  confirmReservation(@RequestBody Reservation reservation){
        boolean ret = reservationService.confirmReservation(reservation);
        return ResponseEntity.ok().body(ret);
    }

    @PostMapping(value = "/cancelReservation")
    public ResponseEntity<Boolean>  cancelReservation(@RequestBody Reservation reservation){
        boolean ret = reservationService.cancelReservation(reservation);
        return ResponseEntity.ok().body(ret);
    }
}
