package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sasyami.boat.entities.Ship;

import java.util.List;
@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    public List<Ship> findAllByConstrYear(Integer constr_year);
    public List<Ship> findAllByShipClass(Character shipClass);
    public List<Ship> findAllByShipType(String shipType);
    public List<Ship> findAllByShipName(String name);


}
