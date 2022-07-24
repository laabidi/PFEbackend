package smartup.microservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeInfoPerso;
@Repository
public interface DemandeInfoPersoRepository extends JpaRepository<DemandeInfoPerso, Long> {
	List<DemandeInfoPerso> findDemandeInfoPersoByActive(@Param("active") int active);
}
