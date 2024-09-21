package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Cabin;
@Repository
public interface CabinRepository extends JpaRepository<Cabin,Long> {
}
