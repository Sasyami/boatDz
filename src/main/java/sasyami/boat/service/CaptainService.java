package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.CaptainRepository;

@Service
@RequiredArgsConstructor
public class CaptainService {
    private final CaptainRepository repository;
}
