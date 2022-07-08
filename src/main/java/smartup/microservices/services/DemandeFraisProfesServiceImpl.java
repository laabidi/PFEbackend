package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeFraisProfes;
import smartup.microservices.repositories.DemandeFraisProfesRepository;


@Service
public class DemandeFraisProfesServiceImpl implements DemandeFraisProfesService{
	
	@Autowired
	DemandeFraisProfesRepository drep;

	private static final Logger l = LogManager.getLogger(DemandeFraisProfesServiceImpl.class);
	@Override
	public DemandeFraisProfes addDemandeFraisProfes(DemandeFraisProfes dat) {
		
		return drep.save(dat);
	}

	@Override
	public List<DemandeFraisProfes> retrieveAllDemandeFraisProfess() {
		List<DemandeFraisProfes> DemandeFraisProfess=(List<DemandeFraisProfes>) drep.findAll();
		l.log(Level.INFO, () ->"DemandeFraisProfes : " +DemandeFraisProfess);
	return DemandeFraisProfess;
	}

	@Override
	public DemandeFraisProfes updateDemandeFraisProfes(DemandeFraisProfes dat) {
		return drep.save(dat) ;
	}

	@Override
	public Optional<DemandeFraisProfes> retrieveDemandeFraisProfes(String id) {
		Optional<DemandeFraisProfes> DemandeFraisProfes = drep.findById(Long.parseLong(id));
		 l.log(Level.INFO, () ->"DemandeFraisProfes : " +DemandeFraisProfes);
			
		return DemandeFraisProfes;
	}

	@Override
	public DemandeFraisProfes getDemandeFraisProfesById(int id) {
		Optional<DemandeFraisProfes> d = drep.findById(1L);
		DemandeFraisProfes dat = new DemandeFraisProfes();
		if (d.isPresent()) {
			  dat= d.get();
			}
		return dat;
	}

	@Override
	public void deleteDemandeFraisProfesById(int id) {
		{
			Optional<DemandeFraisProfes> d = drep.findById(1L);

			DemandeFraisProfes DemandeFraisProfes = new DemandeFraisProfes();
			if (d.isPresent()) {
				DemandeFraisProfes= d.get();
				}
			
			drep.delete(DemandeFraisProfes);
		}
	}


}
