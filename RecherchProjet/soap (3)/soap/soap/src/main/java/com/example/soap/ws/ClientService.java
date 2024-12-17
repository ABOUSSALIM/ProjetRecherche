package com.example.soap.ws;

import com.example.soap.entities.Client;
import com.example.soap.entities.Reservation;
import com.example.soap.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@WebService(serviceName = "ClientWS")
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @WebMethod
    public Client saveClient(@WebParam Client client) {
        return clientRepository.save(client);
    }
    @WebMethod
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    @WebMethod
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    @WebMethod
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
    @WebMethod
    public Client updateclient(Long id, Client clientDetails) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            Client existingclient = client.get();
            existingclient.setId(clientDetails.getId());
            existingclient.setNom(clientDetails.getNom());
            existingclient.setPrenom(clientDetails.getPrenom());
            existingclient.setEmail(clientDetails.getEmail());
            existingclient.setTelephone(clientDetails.getTelephone());
            return clientRepository.save(existingclient);
        }
        return null;
    }
}
