package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sasyami.boat.dto.ServiceRequest;
import sasyami.boat.dto.ServiceResponse;
import sasyami.boat.entities.Cabin;
import sasyami.boat.entities.Ship;
import sasyami.boat.repository.CabinRepository;
import sasyami.boat.repository.ShipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipService {
    private final ShipRepository repository;
    private final CabinRepository cabinRepository;
    public ShipRepository getRepository(){
        return repository;
    }

    public Optional<Ship> addNewShip(Ship ship){
        try{

            return Optional.of(repository.save(ship));
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
    public Optional<Ship> findById(Long id){return repository.findById(id);}

    public ServiceResponse getShipCount(ServiceRequest req) {

        return new ServiceResponse((long) repository.findAllByShipClass(req.getShipClass()).size());
    }
    public List<Ship> findByName(String name){

        return  repository.findAllByShipName(name);
    }
    public List<Ship> findAll(){
        List<Ship> ships =  repository.findAll();
        System.out.println(ships.get(10).isUseable.toString());
        return ships;
    }
    @Transactional
    public void deleteShip(Ship ship){
        repository.delete(ship);
    }

    public Integer countCabins(Ship ship, Integer clazz){
        Cabin c = cabinRepository.findByCabinClassAndShip(clazz.shortValue(),ship);
        return c == null?
                0 : c.getCount();
    }

}
