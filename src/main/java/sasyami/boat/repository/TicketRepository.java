package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
