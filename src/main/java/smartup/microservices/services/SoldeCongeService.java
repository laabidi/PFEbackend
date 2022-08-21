package smartup.microservices.services;

import java.util.List;

import smartup.microservices.entities.SoldeConge;

public interface SoldeCongeService {
	public SoldeConge addSoldeConge(SoldeConge sc);
	public List<SoldeConge> retrieveAllSoldeConges();
	public SoldeConge getSoldeCongeById(Long id);
}
