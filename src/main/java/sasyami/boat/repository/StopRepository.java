package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Flight;
import sasyami.boat.entities.Stop;

import java.util.List;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
    @Query("select s from Stop s where s.flight.id = ?1 order by s.stnumber asc")
    public List<Stop> findAllByFlightIdOrderByStnumber(Long flight_id);
}
