package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.dto.FlightAddUpdateRequest;
import sasyami.boat.dto.StopDTO;
import sasyami.boat.entities.Flight;
import sasyami.boat.entities.Stop;
import sasyami.boat.repository.FlightRepository;
import sasyami.boat.repository.StopRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository repository;
    private final StopRepository stopRepository;
    public List<Stop> findStopsById(Long flight_id){
        System.out.println(stopRepository.findAllByFlightIdOrderByStnumber(flight_id).size());
        return stopRepository.
                findAllByFlightIdOrderByStnumber(flight_id);
    }
    public List<Flight> getAll(){
        return repository.findAll();
    }
    public Optional<Flight> addFlight(Flight flight){

        try{

            return Optional.of(repository.save(flight));
        }catch(RuntimeException e){
            return Optional.empty();
        }
    }
    public Optional<Flight> updateFlight(FlightAddUpdateRequest request){
        try{
            Flight f = repository.findById(request.getId()).orElseThrow();
            if (request.getDistance()!=null){
                f.setDistance(request.getDistance());
            }
            if (request.getGuards()!=null){
                f.setGuards(request.getGuards());

            }
            if (request.getShips()!=null){
                f.setGuards(request.getGuards());
            }
            return Optional.of(repository.save(f));
        }catch(RuntimeException e){
            return Optional.empty();

        }
    }
}
