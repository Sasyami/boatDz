package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sasyami.boat.dto.PortDTO;
import sasyami.boat.entities.Port;
import sasyami.boat.service.PortService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PortController {
    private final PortService service;
    @GetMapping("/ports")
    public List<Port> getPorts(){
        return service.getPorts();
    }
    @GetMapping("/ports/{id}")
    public ResponseEntity<PortDTO> getPort(@PathVariable(name = "id") Long id){
        try {
            Port p = service.getPort(id).orElseThrow();
            return ResponseEntity
                    .ok(PortDTO
                                    .builder()
                                    .portName(p.getPortName())
                                    .coordinates(p.getCoordinates())
                                    .country(p.getCountry())
                                    .town(p.getTown())
                                    .build());
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/add/port")
    public ResponseEntity<PortDTO> addPort(@RequestBody Port port){
        try {
            Port p = service.addPort(port).orElseThrow();
            return ResponseEntity
                    .ok(PortDTO
                            .builder()
                            .portName(p.getPortName())
                            .coordinates(p.getCoordinates())
                            .country(p.getCountry())
                            .town(p.getTown())
                            .build());
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/update/port")
    public ResponseEntity<PortDTO> updatePort(@RequestBody Port port){
        try {
            Port p = service.updatePort(port).orElseThrow();
            return ResponseEntity
                    .ok(PortDTO
                            .builder()
                            .portName(p.getPortName())
                            .coordinates(p.getCoordinates())
                            .country(p.getCountry())
                            .town(p.getTown())
                            .build());
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete/port")
    public ResponseEntity<Port> deletePort(@RequestBody Long id){
        return service.deletePort(id);


    }

}
