package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sasyami.boat.dto.CrewDTO;
import sasyami.boat.entities.Crew;
import sasyami.boat.service.CrewService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CrewController {
    private final CrewService service;
    @PutMapping("/add/crew")
    @Transactional
    public ResponseEntity<Crew> addCrew(@RequestBody CrewDTO req){
        return ResponseEntity.of(
                service.addCrew(req.getCrewId(),
                    req.getShipId(),
                    req.getFlightId(),
                    req.getCaptainId()));
    }
    @PutMapping("/update/crew")
    @Transactional
    public ResponseEntity<Crew> updateCrew(@RequestBody CrewDTO req) {
        if (req.getCrewId() == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.of(
                    service
                            .updateCrew(
                                    req.getCrewId()
                                    ,req.getFlightId()
                                    ,req.getShipId()
                                    ,req.getCaptainId()));
        }
    }


    @DeleteMapping("/delete/crew")
    public ResponseEntity<?> deleteCrew(@RequestParam(name="crewId",required = true) Long crewId){
            try{
                service.deleteCrew(crewId);

                return ResponseEntity.status(HttpStatus.OK).build();
            }catch(RuntimeException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such entity");
            }
    }
    @GetMapping("/crew")
    public List<CrewDTO> getCrews(){
        return service.findAll().stream().map(c -> CrewDTO
                .builder()
                .crewId(c.getId())
                .captainId(c.getCaptain().getId())
                .shipId(c.getShip().getId())
                .flightId(c.getFlight().getId())
                .build())
                .collect(Collectors.toList());
    }
    @GetMapping("/crew/{id}")
    public ResponseEntity<CrewDTO> getCrewById(@RequestParam(name = "id") Long id){
         Optional<Crew> c =service.findById(id);
         if (c.isEmpty()){
             return ResponseEntity.badRequest().build();

         }else{
             return ResponseEntity.of(
                     Optional.of(CrewDTO.builder()
                             .crewId(c.get().getId())
                             .captainId(c.get().getCaptain().getId())
                             .flightId(c.get().getFlight().getId())
                             .shipId(c.get().getShip().getId())
                             .build()));
         }

    }

}
