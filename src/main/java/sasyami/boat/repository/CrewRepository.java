package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Crew;

@Repository
public interface CrewRepository extends JpaRepository<Crew,Long> {
}
