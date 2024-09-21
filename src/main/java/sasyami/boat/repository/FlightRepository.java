package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
