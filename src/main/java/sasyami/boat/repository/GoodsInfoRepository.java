package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.GoodsInfo;
@Repository
public interface GoodsInfoRepository extends JpaRepository<GoodsInfo, Long> {
}
