package sasyami.boat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sasyami.boat.repository.GoodsInfoRepository;

@Service
@RequiredArgsConstructor
public class GoodsInfoService {
    private final GoodsInfoRepository repository;
}
