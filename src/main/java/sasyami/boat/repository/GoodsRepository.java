package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Goods;
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
