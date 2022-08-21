package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeFraisProfes;

public interface DemandeFraisProfesService {
	public DemandeFraisProfes addDemandeFraisProfes(DemandeFraisProfes dat);
	public List<DemandeFraisProfes> retrieveAllDemandeFraisProfess();
	public DemandeFraisProfes updateDemandeFraisProfes(DemandeFraisProfes dat);
	public Optional<DemandeFraisProfes> retrieveDemandeFraisProfes(Long id);
	public DemandeFraisProfes getDemandeFraisProfesById(Long id);
	public void deleteDemandeFraisProfesById(Long id);
	void acceptedemandeById(Long id);
	DemandeFraisProfes activerDemandeFraisProfes(Long id);
	DemandeFraisProfes desactiverDemandeFraisProfes(Long id);
	List<DemandeFraisProfes> getDemandeFraisProfesListActive();
    List<DemandeFraisProfes> getDemandeFraisProfesListDesactive();
	

}
