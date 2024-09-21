package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.PriceListRepository;

@Service
@RequiredArgsConstructor
public class PriceListService {
    private final PriceListRepository repository;
}
