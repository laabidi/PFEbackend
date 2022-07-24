package smartup.microservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeAttesTravail;
@Repository
public interface DemandeAttestTravailRepository extends JpaRepository<DemandeAttesTravail, Long> {
	List<DemandeAttesTravail> findDemandeAttesTravailByActive(@Param("active") int active);
}
