package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeAttesTravail;
@Repository
public interface DemandeAttestTravailRepository extends JpaRepository<DemandeAttesTravail, Long> {

}
