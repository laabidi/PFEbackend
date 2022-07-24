package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeConge;

public interface DemandeCongeService {

	public DemandeConge addDemandeConge(DemandeConge dc);
	public List<DemandeConge> retrieveAllDemandeConges();
	public DemandeConge updateDemandeConge(int id, DemandeConge dc);
	public Optional<DemandeConge> retrieveDemandeConge(int id);
	public DemandeConge getDemandeCongeById(int id);
	public void deleteDemandeCongeById(int id);
	void acceptedemandeById(int id);
	DemandeConge activerDemandeConge(int id);
	DemandeConge desactiverDemandeConge	(int id);
	List<DemandeConge> getDemandeCongeListActive();
    List<DemandeConge> getDemandeCongeListDesactive();
}
