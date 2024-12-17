package com.example.soap.controllers;

import io.grpc.stub.StreamObserver;
import com.example.soap.ws.ReservationService;
import com.example.soap.stubs.*;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class GrpcController extends ReservationServiceGrpc.ReservationServiceImplBase {
    @Autowired
    private  ReservationService reservationService;

    public GrpcController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public void createReservation(CreateReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        Long clientId = request.getClientId();
        Long chambreId = request.getChambreId();
        String dateDebut = request.getDateDebut();
        String dateFin = request.getDateFin();
        String preferences = request.getPreferences();
        com.example.soap.entities.Reservation savedreservation =reservationService.saveReservation(clientId,chambreId,dateDebut,dateFin,preferences);

        var grpcReservation = mapReservationToGrpc(savedreservation);

        responseObserver.onNext(ReservationResponse.newBuilder()
                .setReservation(grpcReservation)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getReservation(GetReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        Long reservationId = request.getId();
        com.example.soap.entities.Reservation reservation = reservationService.getReservationById(reservationId);

        if (reservation != null) {
            var grpcReservation = mapReservationToGrpc(reservation);
            responseObserver.onNext(ReservationResponse.newBuilder()
                    .setReservation(grpcReservation)
                    .build());
        } else {
            // Gérer le cas où la réservation n'est pas trouvée
            responseObserver.onNext(ReservationResponse.newBuilder().build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getAllReservations(GetAllReservationsRequest request, StreamObserver<ReservationList> responseObserver) {
        List<com.example.soap.entities.Reservation> reservations = reservationService.getAllReservations();

        var grpcReservations = reservations.stream()
                .map(this::mapReservationToGrpc)
                .collect(Collectors.toList());

        responseObserver.onNext(ReservationList.newBuilder()
                .addAllReservations(grpcReservations)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateReservation(UpdateReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        Long reservationId = request.getId();
        Long clientId = request.getClientId();
        Long chambreId = request.getChambreId();
        String dateDebut = request.getDateDebut();
        String dateFin = request.getDateFin();
        String preferences = request.getPreferences();
        com.example.soap.entities.Reservation updatedreservation =reservationService.updateReservation(reservationId,clientId,chambreId,dateDebut,dateFin,preferences);

        var grpcReservation = mapReservationToGrpc(updatedreservation);

        responseObserver.onNext(ReservationResponse.newBuilder()
                .setReservation(grpcReservation)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteReservation(DeleteReservationRequest request, StreamObserver<DeleteReservationResponse> responseObserver) {
        Long reservationId = request.getId();
        boolean success = true;
        try {
            reservationService.deleteReservation(reservationId);
        } catch (Exception e) {
            success = false;
        }
        responseObserver.onNext(DeleteReservationResponse.newBuilder()
                .setSuccess(success)
                .build());
        responseObserver.onCompleted();
    }

    // Helper methods for mapping between gRPC and entity objects
    private Reservation mapReservationToGrpc(com.example.soap.entities.Reservation reservation) {
        return Reservation.newBuilder()
                .setId(reservation.getId())
                .setClient(mapClientToGrpc(reservation.getClient()))
                .setChambre(mapChambreToGrpc(reservation.getChambre()))
                .setDateDebut(reservation.getDateDebut().toString())
                .setDateFin(reservation.getDateFin().toString())
                .setPreferences(reservation.getPreferences())
                .build();
    }

    private com.example.soap.entities.Reservation mapReservationFromGrpc(Reservation grpcReservation) {
        var reservation = new com.example.soap.entities.Reservation();
        reservation.setId(grpcReservation.getId());
        reservation.setClient(mapClientFromGrpc(grpcReservation.getClient()));
        reservation.setChambre(mapChambreFromGrpc(grpcReservation.getChambre()));
        // Assuming you have a method to parse string to LocalDate
        reservation.setDateDebut(convertStringToLocalDate((grpcReservation.getDateDebut())));
        reservation.setDateFin(convertStringToLocalDate(grpcReservation.getDateFin()));
        reservation.setPreferences(grpcReservation.getPreferences());
        return reservation;
    }

    private Client mapClientToGrpc(com.example.soap.entities.Client client) {
        return Client.newBuilder()
                .setId(client.getId())
                .setNom(client.getNom())
                .setPrenom(client.getPrenom())
                .setEmail(client.getEmail())
                .setTelephone(client.getTelephone())
                .build();
    }

    private com.example.soap.entities.Client mapClientFromGrpc(Client grpcClient) {
        var client = new com.example.soap.entities.Client();
        client.setId(grpcClient.getId());
        client.setNom(grpcClient.getNom());
        client.setPrenom(grpcClient.getPrenom());
        client.setEmail(grpcClient.getEmail());
        client.setTelephone(grpcClient.getTelephone());
        return client;
    }

    private Chambre mapChambreToGrpc(com.example.soap.entities.Chambre chambre) {
        return Chambre.newBuilder()
                .setId(chambre.getId())
                .setPrix(chambre.getPrix())
                .setDisponible(chambre.getDisponible())
                .build();
    }

    private com.example.soap.entities.Chambre mapChambreFromGrpc(Chambre grpcChambre) {
        var chambre = new com.example.soap.entities.Chambre();
        chambre.setId(grpcChambre.getId());
        chambre.setDisponible(grpcChambre.getDisponible());
        chambre.setPrix(grpcChambre.getPrix());
        return chambre;
    }
    public static LocalDate convertStringToLocalDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null; // Vous pouvez gérer ce cas selon vos besoins
        }

        // Utilisation du format ISO_LOCAL_DATE (par exemple: "2024-12-15")
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            // Si le format est incorrect, vous pouvez ajouter une gestion d'erreur appropriée
            System.out.println("Erreur de conversion de la date : " + dateString);
            return null; // Ou lancer une exception selon votre logique métier
        }
    }
}

