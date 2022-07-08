package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeInfoPerso;
@Repository
public interface DemandeInfoPersoRepository extends JpaRepository<DemandeInfoPerso, Long> {

}
