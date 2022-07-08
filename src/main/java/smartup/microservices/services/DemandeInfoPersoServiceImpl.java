package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeInfoPerso;
import smartup.microservices.repositories.DemandeInfoPersoRepository;



@Service
public class DemandeInfoPersoServiceImpl implements DemandeInfoPersoSevice {
	@Autowired
	DemandeInfoPersoRepository dipr;
	
	
	private static final Logger l = LogManager.getLogger(DemandeInfoPersoServiceImpl.class);

	@Override
	public DemandeInfoPerso addDemandeInfoPerso(DemandeInfoPerso dc) {
		
		return dipr.save(dc);
	}

	@Override
	public List<DemandeInfoPerso> retrieveAllDemandeInfoPersos() {
		
		List<DemandeInfoPerso> DemandeInfoPersos=(List<DemandeInfoPerso>) dipr.findAll();
		l.log(Level.INFO, () ->"DemandeInfoPerso : " +DemandeInfoPersos);
	return DemandeInfoPersos;
}
	

	@Override
	public DemandeInfoPerso updateDemandeInfoPerso(DemandeInfoPerso dc) {
		
		return dipr.save(dc) ;
	}

	@Override
	public Optional<DemandeInfoPerso> retrieveDemandeInfoPerso(String id) {
		
		Optional<DemandeInfoPerso> DemandeInfoPerso = dipr.findById(Long.parseLong(id));
		 l.log(Level.INFO, () ->"DemandeInfoPerso : " +DemandeInfoPerso);
			
		return DemandeInfoPerso;
	}

	@Override
	public DemandeInfoPerso getDemandeInfoPersoById(int id) {
		Optional<DemandeInfoPerso> d = dipr.findById(1L);
		DemandeInfoPerso dc = new DemandeInfoPerso();
		if (d.isPresent()) {
			  dc= d.get();
			}
		return dc;
	}

	@Override
	public void deleteDemandeInfoPersoById(int id) {
		{
			Optional<DemandeInfoPerso> d = dipr.findById(1L);

			DemandeInfoPerso DemandeInfoPerso = new DemandeInfoPerso();
			if (d.isPresent()) {
				DemandeInfoPerso= d.get();
				}
			
			dipr.delete(DemandeInfoPerso);
		}
	}

}
