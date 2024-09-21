package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.CrewRepository;

@Service
@RequiredArgsConstructor
public class CrewService {
    private final CrewRepository repository;
}
