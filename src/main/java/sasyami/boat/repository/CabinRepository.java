package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Cabin;
import sasyami.boat.entities.Ship;

@Repository
public interface CabinRepository extends JpaRepository<Cabin,Long> {
    @Query("select c from Cabin c where c.ship = ?2 and c.cabinClass = ?1")
    public Cabin findByCabinClassAndShip(Short cabin_class, Ship ship);
}
