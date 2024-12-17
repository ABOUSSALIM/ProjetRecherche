package com.example.soap.ws;
import com.example.soap.entities.Chambre;
import com.example.soap.entities.Client;
import com.example.soap.entities.Reservation;
import com.example.soap.repositories.ChambreRepository;
import com.example.soap.repositories.ClientRepository;
import com.example.soap.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Component
@WebService(serviceName = "ChambreWS")
public class ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @WebMethod
    public Reservation saveReservation(@WebParam(name="clientId") Long clientId, @WebParam(name="chambreId") Long chambreId,
                                       @WebParam(name="dateDebut") String dateDebut, @WebParam(name="dateFin") String dateFin,
                                       @WebParam(name="preferences") String preferences) {
        // Récupérer le client par son ID
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID: " + clientId));

        // Récupérer la chambre par son ID
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée avec l'ID: " + chambreId));


        // Créer la nouvelle réservation
        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setChambre(chambre);
        reservation.setDateDebut(LocalDate.parse(dateDebut));
        reservation.setDateFin(LocalDate.parse(dateFin));
        reservation.setPreferences(preferences);

        // Mettre à jour la disponibilité de la chambre
        chambre.setDisponible(false);
        chambreRepository.save(chambre);

        // Sauvegarder et retourner la réservation
        return reservationRepository.save(reservation);
    }
    @WebMethod
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

@WebMethod
public Reservation getReservationById( @WebParam Long id) {
    return reservationRepository.findById(id).orElse(null);
}
@WebMethod
public List<Reservation> getAllReservations() {
    return reservationRepository.findAll();
}
@WebMethod
public void deleteReservation( @WebParam Long id) {
    reservationRepository.deleteById(id);
}
@WebMethod
public Reservation updateReservation(@WebParam(name="reservation_id") Long id, @WebParam(name="clientId") Long clientId, @WebParam(name="chambreId") Long chambreId,
                                     @WebParam(name="dateDebut") String dateDebut, @WebParam(name="dateFin") String dateFin,
                                     @WebParam(name="preferences") String preferences) {
    Optional<Reservation> reservation = reservationRepository.findById(id);
    Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID: " + clientId));
    Chambre chambre = chambreRepository.findById(chambreId)
            .orElseThrow(() -> new RuntimeException("Chambre non trouvée avec l'ID: " + chambreId));
    if (reservation.isPresent()) {
        Reservation existingReservation = reservation.get();
        existingReservation.setClient(client);
        existingReservation.setChambre(chambre);
        existingReservation.setDateDebut(LocalDate.parse(dateDebut));
        existingReservation.setDateFin(LocalDate.parse(dateFin));
        existingReservation.setPreferences(preferences);
        return reservationRepository.save(existingReservation);
    }
    return null;
}
}



