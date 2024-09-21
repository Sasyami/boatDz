package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.StopRepository;

@Service
@RequiredArgsConstructor
public class StopService {
    private final StopRepository repository;
}
