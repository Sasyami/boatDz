package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.TicketRepository;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository repository;
}
