package com.example.soap.ws;

import com.example.soap.entities.Chambre;
import com.example.soap.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Optional;

@Component
@WebService(serviceName = "ChambreWS")
public class ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
    @WebMethod
    public Chambre saveChambre(@WebParam() Chambre chambre) {
        return chambreRepository.save(chambre);
    }
    @WebMethod
    public Chambre getChambreById(@WebParam Long id) {
        return chambreRepository.findById(id).orElse(null);
    }
    @WebMethod
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }
    @WebMethod
    public void deleteChambre(@WebParam Long id) {
        chambreRepository.deleteById(id);
    }
    @WebMethod
    public Chambre updateChambre(@WebParam Long id,@WebParam Chambre ChambreDetails) {
        Optional<Chambre> Chambre = chambreRepository.findById(id);
        if (Chambre.isPresent()) {
            Chambre existingChambre = Chambre.get();
            existingChambre.setId(ChambreDetails.getId());
            existingChambre.setType(ChambreDetails.getType());
            existingChambre.setPrix(ChambreDetails.getPrix());
            existingChambre.setDisponible(ChambreDetails.getDisponible());
            return chambreRepository.save(existingChambre);
        }
        return null;
    }

}
