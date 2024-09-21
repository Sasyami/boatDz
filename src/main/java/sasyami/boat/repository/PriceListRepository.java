package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.PriceList;
@Repository
public interface PriceListRepository extends JpaRepository<PriceList,Long> {
}
