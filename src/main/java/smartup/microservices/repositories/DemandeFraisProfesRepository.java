package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeFraisProfes;



@Repository
public interface DemandeFraisProfesRepository extends JpaRepository <DemandeFraisProfes, Long>{

}
