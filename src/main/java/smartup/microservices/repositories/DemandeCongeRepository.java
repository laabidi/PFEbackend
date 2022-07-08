package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.DemandeConge;



@Repository
public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long> {



}
