package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeAvanceSalaire;

@Repository
public interface DemandeAvanceSalaireRepository extends JpaRepository<DemandeAvanceSalaire, Long>{

}
