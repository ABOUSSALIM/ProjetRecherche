package com.example.soap.controllers;


import com.example.soap.entities.Reservation;
import com.example.soap.entities.Client;
import com.example.soap.entities.Chambre;
import com.example.soap.ws.ReservationService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@WebService(serviceName = "ReservationSOAPService")
public class SoapController {

    @Autowired
    private ReservationService reservationService;

    @WebMethod(operationName = "createReservation")
    public Reservation createReservation(
            @WebParam(name = "clientId") Long clientId,
            @WebParam(name = "chambreId") Long chambreId,
            @WebParam(name = "dateDebut") String dateDebut,
            @WebParam(name = "dateFin") String dateFin,
            @WebParam(name = "preferences") String preferences) {
        return reservationService.saveReservation(clientId, chambreId, dateDebut, dateFin, preferences);
    }

    @WebMethod(operationName = "getReservation")
    public Reservation getReservation(@WebParam(name = "reservationId") Long reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @WebMethod(operationName = "getAllReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @WebMethod(operationName = "updateReservation")
    public Reservation updateReservation(
            @WebParam(name = "reservationId") Long reservationId,
            @WebParam(name = "clientId") Long clientId,
            @WebParam(name = "chambreId") Long chambreId,
            @WebParam(name = "dateDebut") String dateDebut,
            @WebParam(name = "dateFin") String dateFin,
            @WebParam(name = "preferences") String preferences) {
        return reservationService.updateReservation(reservationId, clientId, chambreId, dateDebut, dateFin, preferences);
    }

    @WebMethod(operationName = "deleteReservation")
    public String deleteReservation(@WebParam(name = "reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return "Reservation with ID " + reservationId + " has been deleted.";
    }
}

