package smartup.microservices.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import smartup.microservices.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    List<Utilisateur> findUtilisateurByActive(int active);
    List<Utilisateur> findUtilisateurByActiveAndUsernameIsNotLike(@Param("active") int active, @Param("nom")String nom);
    Optional<Utilisateur> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
