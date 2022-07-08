package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeInfoPerso;

public interface DemandeInfoPersoSevice {
	public DemandeInfoPerso addDemandeInfoPerso(DemandeInfoPerso dc);
	public List<DemandeInfoPerso> retrieveAllDemandeInfoPersos();
	public DemandeInfoPerso updateDemandeInfoPerso(DemandeInfoPerso e);
	public Optional<DemandeInfoPerso> retrieveDemandeInfoPerso(String id);
	public DemandeInfoPerso getDemandeInfoPersoById(int id);
	public void deleteDemandeInfoPersoById(int id);

}
