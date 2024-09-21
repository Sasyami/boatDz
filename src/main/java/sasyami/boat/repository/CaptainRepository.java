package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Captain;
@Repository
public interface CaptainRepository extends JpaRepository<Captain,Long> {
}
