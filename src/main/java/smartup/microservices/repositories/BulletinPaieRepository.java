package smartup.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.BulletinPaie;

@Repository
public interface BulletinPaieRepository extends JpaRepository<BulletinPaie, Long> {

}
