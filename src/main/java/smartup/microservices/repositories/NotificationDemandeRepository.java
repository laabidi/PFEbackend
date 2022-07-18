package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.NotificationDemande;
@Repository
public interface NotificationDemandeRepository extends JpaRepository<NotificationDemande, Long>{

}
