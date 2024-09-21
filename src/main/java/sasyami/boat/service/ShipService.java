package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sasyami.boat.dto.ServiceRequest;
import sasyami.boat.dto.ServiceResponse;
import sasyami.boat.entities.Ship;
import sasyami.boat.repository.ShipRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipService {
    private final ShipRepository repository;
    public ShipRepository getRepository(){
        return repository;
    }
    @Transactional
    public void addNewShip(Ship ship){ repository.save(ship);}
    public Optional<Ship> findById(Long id){return repository.findById(id);}


    @Transactional
    public ServiceResponse getShipCount(ServiceRequest req) {

        return new ServiceResponse((long) repository.findAllByShipClass(req.getShipClass()).size());
    }
}
