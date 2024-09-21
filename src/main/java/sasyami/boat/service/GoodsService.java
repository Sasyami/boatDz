package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.GoodsRepository;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository repository;
}
