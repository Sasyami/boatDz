package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sasyami.boat.dto.FlightAddUpdateRequest;
import sasyami.boat.dto.FlightDTO;
import sasyami.boat.dto.PortDTO;
import sasyami.boat.dto.StopDTO;
import sasyami.boat.entities.Flight;
import sasyami.boat.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FlightController {
    private final FlightService service;
    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightDTO> getFLightById(@PathVariable(name = "id") Long id) {

        var list = service
                .findStopsById(id)
                .stream()
                .map(s -> StopDTO
                        .builder()
                        .arr_date(s.getArr_date())
                        .dep_date(s.getDep_date())
                        .port(PortDTO
                                .builder()
                                .port_name(s
                                        .getPort()
                                        .getPortName())
                                .coordinates(s
                                        .getPort()
                                        .getCoordinates())
                                .country(s
                                        .getPort()
                                        .getCountry())
                                .town(s
                                        .getPort()
                                        .getTown())
                                .build())
                        .build()).collect(Collectors.toList());
        return ResponseEntity.ok(FlightDTO
                .builder()
                .flightId(id).stopDTOlist(list)
                .build());
    }
    @GetMapping("/flights")
    public List<FlightDTO> getFlights(){
        return service.getAll().stream().map(f -> FlightDTO
                .builder()
                .flightId(f.getId())
                .stopDTOlist(service
                        .findStopsById(f.getId())
                        .stream()
                        .map(s -> StopDTO
                                .builder()
                                .arr_date(s.getArr_date())
                                .dep_date(s.getDep_date())
                                .port(PortDTO
                                        .builder()
                                        .port_name(s
                                                .getPort()
                                                .getPortName())
                                        .coordinates(s
                                                .getPort()
                                                .getCoordinates())
                                        .country(s
                                                .getPort()
                                                .getCountry())
                                        .town(s
                                                .getPort()
                                                .getTown())
                                        .build())
                                .build()).collect(Collectors.toList()))
                .build())
                .collect(Collectors.toList());

    }
    @PutMapping("/add/flight")
    public ResponseEntity<Flight> addFlight(@RequestBody FlightAddUpdateRequest request){
       return ResponseEntity.of(service.addFlight(Flight
               .builder()
               .id(request.getId())
               .distance(request.getDistance())
               .guards(request.getGuards())
               .ships(request.getShips())
               .build()));
    }
    @PutMapping("/update/flight")
    public ResponseEntity<Flight> updateFlight(@RequestBody FlightAddUpdateRequest request){
        return ResponseEntity.of(service.updateFlight(request));
    }




}
