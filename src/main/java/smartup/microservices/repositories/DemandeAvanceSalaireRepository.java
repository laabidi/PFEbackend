package smartup.microservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeAvanceSalaire;

@Repository
public interface DemandeAvanceSalaireRepository extends JpaRepository<DemandeAvanceSalaire, Long>{
	List<DemandeAvanceSalaire> findDemandeAvanceSalaireByActive(@Param("active") int active);
}
