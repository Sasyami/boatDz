package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Flight;
import sasyami.boat.entities.Port;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
