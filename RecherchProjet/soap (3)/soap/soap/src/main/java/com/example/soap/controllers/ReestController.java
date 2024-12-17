package com.example.soap.controllers;

import com.example.soap.entities.Reservation;
import com.example.soap.repositories.ReservationRepository;
import com.example.soap.ws.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReestController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ReservationRepository reservationRepository;
/*
    @PostMapping(value="/reservations",consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public Reservation createReservation(@RequestBody Long clientId,
                                         @RequestBody Long chambreId,
                                         @RequestBody String dateDebut,
                                         @RequestBody String dateFin,
                                         @RequestBody(required = false) String preferences) {
        return reservationService.saveReservation(clientId,chambreId,dateDebut,dateFin,preferences);
    }*/
    @PostMapping(value="/reservations",consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @GetMapping(value="/reservations/{id}",produces = {"application/json", "application/xml"})
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/reservations", produces = {"application/json", "application/xml"})
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PutMapping(value="/reservations", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<Reservation> updateReservation(@RequestBody Long id, @RequestBody Reservation reservation) {
        Optional<Reservation> reservationn = reservationRepository.findById(id);
        if (reservationn.isPresent()) {
            Reservation existingreservation = reservationn.get();
            existingreservation.setId(reservation.getId());
            existingreservation.setClient(reservation.getClient());
            existingreservation.setChambre(reservation.getChambre());
            existingreservation.setPreferences(reservation.getPreferences());
            existingreservation.setDateDebut(reservation.getDateDebut());
            existingreservation.setDateFin(reservation.getDateFin());
            Reservation savedReservation = reservationRepository.save(existingreservation);
            return ResponseEntity.ok(savedReservation);

    } else {
        // Si la réservation n'est pas trouvée
        return ResponseEntity.notFound().build();
    }

    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }
}
