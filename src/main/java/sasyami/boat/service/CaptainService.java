package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sasyami.boat.dto.CaptainDTO;
import sasyami.boat.entities.Captain;
import sasyami.boat.repository.CaptainRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaptainService {
    private final CaptainRepository repository;
    public Optional<Captain> addCaptain(Captain captain){
        try{
            return Optional.of(repository.save(captain));

        }catch(RuntimeException e){
            return Optional.empty();
        }
    }

    public List<Captain> getCaptains(){
        return repository.findAll();
    }
    public Optional<Captain> getCaptain(Long id){
        return repository.findById(id);
    }
    public ResponseEntity<Captain> deleteCaptain(Captain captain){
        try {
            repository.delete(captain);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    public Optional<Captain> updateCaptain(Captain captain){

        try{
            Captain c = repository.getReferenceById(captain.getId());
            if (captain.getFio()!=null){
                c.setFio(captain.getFio());
            }
            if (captain.getAge()!=null){
                c.setAge(captain.getAge());

            }
            if (captain.getPassport()!=null){
                c.setPassport(captain.getPassport());
            }
            if (captain.getXp() != null){
                c.setXp(captain.getXp());
            }
            if (captain.getLicense_end() != null){
                c.setLicense_end(captain.getLicense_end());
            }
            return Optional.of(repository.save(c));
        }catch (RuntimeException e){
            return Optional.empty();
        }

    }
}
