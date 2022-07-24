package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeAvanceSalaire;
import smartup.microservices.entities.DemandeAvanceSalaire;



public interface DemandeAvanceSalaireService {
	public DemandeAvanceSalaire addDemandeAvanceSalaire(DemandeAvanceSalaire dat);
	public List<DemandeAvanceSalaire> retrieveAllDemandeAvanceSalaires();
	public DemandeAvanceSalaire updateDemandeAvanceSalaire(DemandeAvanceSalaire dat);
	public Optional<DemandeAvanceSalaire> retrieveDemandeAvanceSalaire(Long id);
	public DemandeAvanceSalaire getDemandeAvanceSalaireById(Long id);
	public void deleteDemandeAvanceSalaireById(int id);
	void acceptedemandeById(Long id);
	DemandeAvanceSalaire activerDemandeAvanceSalaire(Long id);
	DemandeAvanceSalaire desactiverDemandeAvanceSalaire(Long id);
	List<DemandeAvanceSalaire> getDemandeAvanceSalaireListActive();
    List<DemandeAvanceSalaire> getDemandeAvanceSalaireListDesactive();
}
