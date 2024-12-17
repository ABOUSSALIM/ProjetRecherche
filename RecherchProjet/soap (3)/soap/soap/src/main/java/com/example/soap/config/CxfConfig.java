package com.example.soap.config;

import com.example.soap.controllers.SoapController;
import com.example.soap.ws.ChambreService;
import com.example.soap.ws.ClientService;
import com.example.soap.ws.ReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class CxfConfig {
@Autowired
    private SoapController reservationcontroller;
@Autowired
    private Bus bus;


    @Bean
    public EndpointImpl reservationEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,reservationcontroller);
        endpoint.publish("/ws/reservation");
        return endpoint;
    }
}

