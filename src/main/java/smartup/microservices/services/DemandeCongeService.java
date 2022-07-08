package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeConge;

public interface DemandeCongeService {

	public DemandeConge addDemandeConge(DemandeConge dc);
	public List<DemandeConge> retrieveAllDemandeConges();
	public DemandeConge updateDemandeConge(DemandeConge e);
	public Optional<DemandeConge> retrieveDemandeConge(String id);
	public DemandeConge getDemandeCongeById(int id);
	public void deleteDemandeCongeById(int id);

}
