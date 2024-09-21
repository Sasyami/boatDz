package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.CabinRepository;

@Service
@RequiredArgsConstructor
public class CabinService{
    private final CabinRepository repository;
}
