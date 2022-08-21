package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeInfoPerso;

public interface DemandeInfoPersoSevice {
	public DemandeInfoPerso addDemandeInfoPerso(DemandeInfoPerso dc);
	public List<DemandeInfoPerso> retrieveAllDemandeInfoPersos();
	public DemandeInfoPerso updateDemandeInfoPerso(DemandeInfoPerso e);
	public Optional<DemandeInfoPerso> retrieveDemandeInfoPerso(Long id);
	public DemandeInfoPerso getDemandeInfoPersoById(Long id);
	public void deleteDemandeInfoPersoById(Long id);
	void acceptedemandeById(Long id);
	DemandeInfoPerso activerDemandeInfoPerso(Long id);
	DemandeInfoPerso desactiverDemandeInfoPerso(Long id);
	List<DemandeInfoPerso> getDemandeInfoPersoListActive();
    List<DemandeInfoPerso> getDemandeInfoPersoListDesactive();

}
