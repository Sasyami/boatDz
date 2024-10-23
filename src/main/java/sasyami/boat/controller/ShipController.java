package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sasyami.boat.dto.*;
import sasyami.boat.entities.Ship;
import sasyami.boat.service.ShipService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ShipController {
    private final ShipService service;
    @ResponseBody
    @PutMapping("/add/ship")
    public ResponseEntity<Ship> addShip(@RequestBody Ship ship){

        return ResponseEntity.of(service.addNewShip(ship));
    }
    @DeleteMapping("/delete/ship")
    public void deleteShip(Ship ship){
        service.deleteShip(ship);
    }

    @ResponseBody
    @GetMapping("/ship")
    public List<ShipDTO> findAllShip(){
        return service
                .findAll()
                .stream()
                .map( s -> ShipDTO
                        .builder()
                        .shipType( s.getShipType())
                        .shipName(s.getShipName())
                        .tonns(s.getTonns())
                        .constr_year(s.getConstrYear())
                        .status(s.getStatus())
                        .places1(service
                                .countCabins(s,1))
                        .places2(service
                                .countCabins(s,2))
                        .places3(service
                                .countCabins(s,3))
                        .build())
                .collect(Collectors.toList());
    }
    @ResponseBody
    @GetMapping("/ship/{id}")
    public Optional<Ship> findShipById(@PathVariable("id") Long id){
        return service.getRepository().findById(id);
    }
    @PostMapping("/shipcount")
    public ResponseEntity<ServiceResponse> processRequest(@RequestBody ServiceRequest serviceRequest){
        return ResponseEntity.ok(service.getShipCount(serviceRequest));

    }
    @ResponseBody
    @GetMapping(value = "/ship",params = "name")
    public ResponseEntity<List<ShipNameResponse>> getShipsByName(@RequestParam(name = "name") String name){
        List<Ship> array = service.findByName(name);
        List<ShipNameResponse> resp = new ArrayList<ShipNameResponse>();
        for (Ship ship:array){
            resp.add(
                    ShipNameResponse
                            .builder()
                    .name(ship.getShipName())
                    .ship_type(ship.getShipType())
                    .constr_year(ship.getConstrYear())
                    .tonns(ship.getTonns())
                    .id(ship.getId())
                            .build());
        }

        return ResponseEntity.ok(resp);
    }



}
