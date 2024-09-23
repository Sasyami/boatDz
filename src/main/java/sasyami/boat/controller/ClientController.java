package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sasyami.boat.dto.TextResponse;
import sasyami.boat.service.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping("/mockup-data/login")
    public void loginMockup(){
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
