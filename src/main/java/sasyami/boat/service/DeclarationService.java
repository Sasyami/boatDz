package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.DeclarationRepository;

@Service
@RequiredArgsConstructor
public class DeclarationService {
    private final DeclarationRepository repository;
}
