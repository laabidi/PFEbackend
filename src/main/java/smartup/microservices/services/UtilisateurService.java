package smartup.microservices.services;

import java.util.List;

import smartup.microservices.entities.Utilisateur;

public interface UtilisateurService {
    Utilisateur getUtilisateur(Long id);
    List<Utilisateur> getUtilisateurList();
    List<Utilisateur> getUtilisateurListActive();
    List<Utilisateur> getUtilisateurListDesactive();
    Utilisateur AddUtilisateur(Utilisateur utilisateur);
    Utilisateur UpdateUtilisateur(Long id,Utilisateur utilisateur);
    void DeleteUtilisateur(Long id);
    Utilisateur activerUtilisateur(Long id);
    Utilisateur desactiverUtilisateur(Long id);
}
