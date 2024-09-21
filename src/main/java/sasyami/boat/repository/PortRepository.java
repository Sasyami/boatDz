package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Port;
@Repository
public interface PortRepository extends JpaRepository<Port, Long> {

}
