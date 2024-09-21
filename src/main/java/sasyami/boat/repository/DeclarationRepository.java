package sasyami.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sasyami.boat.entities.Declaration;
@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
}
