package com.example.soap.controllers;

import com.example.soap.dto.ReservationRequest;
import com.example.soap.entities.Chambre;
import com.example.soap.entities.Client;
import com.example.soap.entities.Reservation;

import com.example.soap.repositories.ChambreRepository;
import com.example.soap.repositories.ClientRepository;
import com.example.soap.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class GraphqlController {

    private ReservationRepository reservationRepository;
    private ClientRepository clientRepository;
    private ChambreRepository chambreRepository;

    // Requête: Toutes les réservations
    @QueryMapping
    public List<Reservation> allReservations() {
        return reservationRepository.findAll();
    }

    // Requête: Trouver une réservation par ID
    @QueryMapping
    public Reservation reservationById(@Argument Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));
    }

    // Mutation: Ajouter une réservation



    @MutationMapping
    public Reservation saveReservation(@Argument ReservationRequest reservationRequest){
        Client client= clientRepository.findById(reservationRequest.getClientId()) .orElseThrow(() -> new RuntimeException("Client not found"));;
        Chambre chambre= chambreRepository.findById(reservationRequest.getChambreId()) .orElseThrow(() -> new RuntimeException("Chambre not found"));;
        Reservation reservation = new Reservation();
        // Mettre à jour les champs de la réservation
        reservation.setClient(client);
        reservation.setChambre(chambre);
        reservation.setDateDebut(LocalDate.parse(reservationRequest.getDateDebut()));
        reservation.setDateFin(LocalDate.parse(reservationRequest.getDateFin()));
        reservation.setPreferences(reservationRequest.getPreferences());

        // Sauvegarder la réservation mise à jour
        return reservationRepository.save(reservation);
    }


    @MutationMapping
    public Reservation updateReservation(
            @Argument Long id,
            @Argument ReservationRequest reservationRequest) { // "reservation" ici au lieu de "reservationRequest"

        // Trouver la réservation existante
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));
        Client client= existingReservation.getClient();
        Chambre chambre= existingReservation.getChambre();

        // Mettre à jour les champs de la réservation
        existingReservation.setClient(client);
        existingReservation.setChambre(chambre);
        existingReservation.setDateDebut(LocalDate.parse(reservationRequest.getDateDebut()));
        existingReservation.setDateFin(LocalDate.parse(reservationRequest.getDateFin()));
        existingReservation.setPreferences(reservationRequest.getPreferences());

        // Sauvegarder la réservation mise à jour
        return reservationRepository.save(existingReservation);
    }
    // Mutation: Mettre à jour une réservation

    // Mutation: Supprimer une réservation
    @MutationMapping
    public boolean deleteReservation(@Argument Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Reservation not found with ID: " + id);
        }
    }



}