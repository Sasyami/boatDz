package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sasyami.boat.dto.ServiceRequest;
import sasyami.boat.dto.ServiceResponse;
import sasyami.boat.entities.Ship;
import sasyami.boat.service.ShipService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ShipController {
    private final ShipService service;

    @ResponseBody
    @GetMapping("/ship")
    public List<Ship> findAllShip(){
        return service.getRepository().findAll();
    }
    @ResponseBody
    @GetMapping("/ship/{id}")
    public Optional<Ship> findShipById(@PathVariable("id") Long id){
        return service.getRepository().findById(id);
    }
    @PostMapping("/ship")
    public ResponseEntity<ServiceResponse> processRequest(@RequestBody ServiceRequest serviceRequest){
        return ResponseEntity.ok(service.getShipCount(serviceRequest));

    }



}
