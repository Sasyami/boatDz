package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.PortRepository;

@Service
@RequiredArgsConstructor
public class PortService {
    private final PortRepository repository;
}
