package smartup.microservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeFraisProfes;
import smartup.microservices.entities.DemandeInfoPerso;
import smartup.microservices.entities.DemandeFraisProfes;
import smartup.microservices.entities.NotificationDemande;
import smartup.microservices.repositories.DemandeFraisProfesRepository;
import smartup.microservices.repositories.NotificationDemandeRepository;


@Service
public class DemandeFraisProfesServiceImpl implements DemandeFraisProfesService{
	
	@Autowired
	DemandeFraisProfesRepository drep;

	@Autowired
	NotificationDemandeRepository ndr;
	
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
	public Optional<DemandeFraisProfes> retrieveDemandeFraisProfes(Long id) {
		Optional<DemandeFraisProfes> DemandeFraisProfes = drep.findById((id));
		 l.log(Level.INFO, () ->"DemandeFraisProfes : " +DemandeFraisProfes);
			
		return DemandeFraisProfes;
	}

	@Override
	public DemandeFraisProfes getDemandeFraisProfesById(Long id) {
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

	@Override
	public void acceptedemandeById(Long id) {
		DemandeFraisProfes d = drep.findById(id).get();
		d.setEmployerFraisDemId(1);
		NotificationDemande n=new NotificationDemande();
		n.setBody("Votre  demande information personnelle de "+d.getEmployerFraisDemDate() +"est confirmée !" );
		n.setTitre("Demande accepté");
		n.setDate(new Date());
		
		drep.save(d);
		ndr.save(n);
	}
	

	@Override
	public DemandeFraisProfes activerDemandeFraisProfes(Long id) {
		DemandeFraisProfes p=drep.findById(id).get();
        p.setActive("1");
        return drep.save(p);
	}

	@Override
	public DemandeFraisProfes desactiverDemandeFraisProfes(Long id) {
		 DemandeFraisProfes p=drep.findById(id).get();
	        p.setActive("0");
	        return drep.save(p);
	}

	@Override
	public List<DemandeFraisProfes> getDemandeFraisProfesListActive() {
		return (List<DemandeFraisProfes>)
				drep.findDemandeFraisProfesByActive(1);
	}

	@Override
	public List<DemandeFraisProfes> getDemandeFraisProfesListDesactive() {
		return (List<DemandeFraisProfes>)drep.findDemandeFraisProfesByActive(0);

}

	
}
