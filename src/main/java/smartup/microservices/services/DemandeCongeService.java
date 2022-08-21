package smartup.microservices.services;

import java.util.List;

import smartup.microservices.entities.DemandeConge;

public interface DemandeCongeService {

	public DemandeConge addDemandeConge(DemandeConge dc);
	public List<DemandeConge> retrieveAllDemandeConges();
	public DemandeConge updateDemandeConge(Long id, DemandeConge dc);
	public DemandeConge getDemandeCongeById(Long id);
	public void deleteDemandeCongeById(Long id);
	void acceptedemandeById(Long id);
	DemandeConge activerDemandeConge(Long id);
	DemandeConge desactiverDemandeConge	(Long id);
	List<DemandeConge> getDemandeCongeListActive();
    List<DemandeConge> getDemandeCongeListDesactive();
}
