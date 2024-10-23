package sasyami.boat.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sasyami.boat.dto.CrewDTO;
import sasyami.boat.entities.Crew;
import sasyami.boat.repository.CaptainRepository;
import sasyami.boat.repository.CrewRepository;
import sasyami.boat.repository.FlightRepository;
import sasyami.boat.repository.ShipRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrewService {
    private final CrewRepository repository;
    private final ShipRepository shipRepository;
    private final FlightRepository flightRepository;
    private final CaptainRepository captainRepository;

    @Transactional
    public Optional<Crew> addCrew(Long crewId, Long shipId, Long flightId,Long captainId){
        try {
            Crew ret = new Crew(crewId,
                    flightRepository.findById(flightId).orElseThrow(),
                    captainRepository.findById(captainId).orElseThrow(),
                    shipRepository.findById(shipId).orElseThrow());
            return Optional.of(ret);
        }catch(RuntimeException e){
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<Crew> updateCrew(Long crewId, Long flightId, Long shipId, Long captainId){
        try{
            Crew ret = repository.findById(crewId).orElseThrow();
            if (flightId != null){
                ret.setFlight(flightRepository.findById(flightId).orElseThrow());
            }
            if (shipId != null){
                ret.setShip(shipRepository.findById(shipId).orElseThrow());

            }
            if (captainId != null){
                ret.setCaptain(captainRepository.findById(captainId).orElseThrow());
            }



            return Optional.of(repository.save(ret));
        }catch(RuntimeException e){
            return Optional.empty();
        }
    }

    @Transactional
    public void deleteCrew(Long crewId) throws NoSuchElementException {
        repository.delete(repository.findById(crewId).orElseThrow());
    }

    public Optional<Crew> findById(Long id){
        return repository.findById(id);
    }

    public List<Crew> findAll(){
        return repository.findAll();
    }
}
