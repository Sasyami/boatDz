package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sasyami.boat.dto.CaptainDTO;
import sasyami.boat.dto.CaptainUpdateDTO;
import sasyami.boat.dto.CrewDTO;
import sasyami.boat.entities.Captain;
import sasyami.boat.service.CaptainService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CaptainController {
    private final CaptainService service;
    @PutMapping("/add/captain")
    @Transactional
    public ResponseEntity<Captain> addCaptain(@RequestBody CaptainDTO req){
        return ResponseEntity.of(
                service.addCaptain(new Captain(null,
                        req.getXp(),
                        req.getPassport(),
                        req.getLicense_end(),
                        req.getAge(),
                        req.getFio())));
    }
    @PutMapping("/add/captain")
    @Transactional
    public ResponseEntity<Captain> updateCaptain(@RequestBody CaptainUpdateDTO req){
        return ResponseEntity.of(
                service.updateCaptain(new Captain(req.getId(),
                        req.getXp(),
                        req.getPassport(),
                        req.getLicense_end(),
                        req.getAge(),
                        req.getFio())));
    }
    @Transactional
    @DeleteMapping("/delete/captain")
    public ResponseEntity<Captain> deleteCaptain(@RequestBody Long id){
        return service.deleteCaptain(service.getCaptain(id));
    }
    @GetMapping("/captain/{id}")
    public Optional<Captain> getCaptain(@PathVariable(name="id") Long id){
        return service.getCaptain(id);
    }
    @GetMapping("/captain")
    public Optional<Captain> getCaptains(){
        return service.getCaptains();
    }











}
