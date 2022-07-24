package smartup.microservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeConge;



@Repository
public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Integer> {
	List<DemandeConge> findDemandeCongeByActive(@Param("active") int active);


}
