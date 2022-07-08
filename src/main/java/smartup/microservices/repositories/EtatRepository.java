package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.Etat;

@Repository
public interface EtatRepository extends JpaRepository<Etat, Long>{

}
