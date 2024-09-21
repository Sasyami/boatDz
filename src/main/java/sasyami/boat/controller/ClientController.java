package sasyami.boat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sasyami.boat.service.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;
    @GetMapping("/mockup-data")
    public void loginMockup(){

    }
}
