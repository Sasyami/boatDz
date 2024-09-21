package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
}
