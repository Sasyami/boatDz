package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sasyami.boat.dto.ClientDTO;
import sasyami.boat.dto.TextResponse;
import sasyami.boat.entities.Client;
import sasyami.boat.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @PutMapping("/add/client")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        return ResponseEntity.of(service.addOrUpdateClient(client));
    }

    @DeleteMapping("/delete/client")
    public ResponseEntity<Void> deleteClient(@RequestBody Client client){
        return service.deleteClient(client);
    }

    @PutMapping("/update/client")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){

        return ResponseEntity.of(service.addOrUpdateClient(client));
    }

    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
        return service
                .getClients()
                .stream()
                .map(
                        c -> ClientDTO
                                .builder()
                                .id(c.getId())
                                .account(c.getAccount())
                                .fio(c.getFio())
                                .build())
                .collect(Collectors.toList());
    }
    @GetMapping("/refresher")
    public TextResponse refresher(@RequestParam(name="passwd",required = false) Integer passwd){
        if (passwd!=null && passwd == 123){
            service.refreshBase();
            return new TextResponse(200,"Ok");
        }else{
            return new TextResponse(100, "Not ok");
        }

    }


}
