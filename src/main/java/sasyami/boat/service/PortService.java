package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sasyami.boat.entities.Port;
import sasyami.boat.repository.PortRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortService {
    private final PortRepository repository;
    public List<Port> getPorts(){
        return repository.findAll();
    }
    public Optional<Port> getPort(Long id){
        return repository.findById(id);
    }

    public Optional<Port> addPort(Port port){
        try{
            return Optional.of(repository.save(port));
        }
        catch(RuntimeException e){
            return Optional.empty();
        }
    }
    public ResponseEntity<Port> deletePort(Long id){
        try {
            repository.delete(repository.findById(id).orElseThrow());
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }
    public Optional<Port> updatePort(Port port){

        try {
            Port p = repository.findById(port.getId()).orElseThrow();
            if (port.getPortName()!=null){
                p.setPortName(port.getPortName());
            }
            if (port.getCoordinates()!=null){
                p.setCoordinates(port.getCoordinates());
            }
            if (port.getCountry()!=null){
                p.setCountry(port.getCountry());
            }
            if (port.getTown()!=null){
                p.setTown(port.getTown());
            }
            return Optional.of(repository.save(p));
        }catch(RuntimeException e){
            return Optional.empty();
        }
    }

}
