package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeConge;
import smartup.microservices.repositories.DemandeCongeRepository;

@Service
public class DemandeCongeServiceImpl implements DemandeCongeService{

	
	@Autowired
	DemandeCongeRepository drep;
	
	
	private static final Logger l = LogManager.getLogger(DemandeCongeServiceImpl.class);

	@Override
	public DemandeConge addDemandeConge(DemandeConge dc) {
		
		return drep.save(dc);
	}

	@Override
	public List<DemandeConge> retrieveAllDemandeConges() {
		
		List<DemandeConge> DemandeConges=(List<DemandeConge>) drep.findAll();
		l.log(Level.INFO, () ->"DemandeConge : " +DemandeConges);
	return DemandeConges;
}
	

	@Override
	public DemandeConge updateDemandeConge(DemandeConge dc) {
		
		return drep.save(dc) ;
	}

	@Override
	public Optional<DemandeConge> retrieveDemandeConge(String id) {
		
		Optional<DemandeConge> demandeConge = drep.findById(Long.parseLong(id));
		 l.log(Level.INFO, () ->"demandeConge : " +demandeConge);
			
		return demandeConge;
	}

	@Override
	public DemandeConge getDemandeCongeById(int id) {
		Optional<DemandeConge> d = drep.findById(1L);
		DemandeConge dc = new DemandeConge();
		if (d.isPresent()) {
			  dc= d.get();
			}
		return dc;
	}

	@Override
	public void deleteDemandeCongeById(int id) {
		{
			Optional<DemandeConge> d = drep.findById(1L);

			DemandeConge DemandeConge = new DemandeConge();
			if (d.isPresent()) {
				DemandeConge= d.get();
				}
			
			drep.delete(DemandeConge);
		}
	}

}
