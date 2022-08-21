package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.SoldeConge;
@Repository
public interface SoldeCongeRepository  extends JpaRepository<SoldeConge, Long>{

}
