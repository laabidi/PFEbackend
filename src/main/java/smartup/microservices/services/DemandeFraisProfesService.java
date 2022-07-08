package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeFraisProfes;

public interface DemandeFraisProfesService {
	public DemandeFraisProfes addDemandeFraisProfes(DemandeFraisProfes dat);
	public List<DemandeFraisProfes> retrieveAllDemandeFraisProfess();
	public DemandeFraisProfes updateDemandeFraisProfes(DemandeFraisProfes dat);
	public Optional<DemandeFraisProfes> retrieveDemandeFraisProfes(String id);
	public DemandeFraisProfes getDemandeFraisProfesById(int id);
	public void deleteDemandeFraisProfesById(int id);
	
}
