package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeAvanceSalaire;



public interface DemandeAvanceSalaireService {
	public DemandeAvanceSalaire addDemandeAvanceSalaire(DemandeAvanceSalaire dat);
	public List<DemandeAvanceSalaire> retrieveAllDemandeAvanceSalaires();
	public DemandeAvanceSalaire updateDemandeAvanceSalaire(DemandeAvanceSalaire dat);
	public Optional<DemandeAvanceSalaire> retrieveDemandeAvanceSalaire(String id);
	public DemandeAvanceSalaire getDemandeAvanceSalaireById(int id);
	public void deleteDemandeAvanceSalaireById(int id);

}
