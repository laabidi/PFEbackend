package smartup.microservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeFraisProfes;



@Repository
public interface DemandeFraisProfesRepository extends JpaRepository <DemandeFraisProfes, Long>{
	List<DemandeFraisProfes> findDemandeFraisProfesByActive(@Param("active") int active);
}
