package smartup.microservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeAvanceSalaire;
import smartup.microservices.entities.NotificationDemande;
import smartup.microservices.repositories.DemandeAvanceSalaireRepository;
import smartup.microservices.repositories.NotificationDemandeRepository;

@Service
public class DemandeAvanceSalaireServiceImpl implements DemandeAvanceSalaireService{

	@Autowired
	DemandeAvanceSalaireRepository drep;
	
	@Autowired
	NotificationDemandeRepository ndr;
	
	private static final Logger l = LogManager.getLogger(DemandeAvanceSalaireServiceImpl.class);

	@Override
	public DemandeAvanceSalaire addDemandeAvanceSalaire(DemandeAvanceSalaire dat) {
		
		return drep.save(dat);
	}

	@Override
	public List<DemandeAvanceSalaire> retrieveAllDemandeAvanceSalaires() {
		List<DemandeAvanceSalaire> DemandeAvanceSalaires=(List<DemandeAvanceSalaire>) drep.findAll();
		l.log(Level.INFO, () ->"DemandeAvanceSalaire : " +DemandeAvanceSalaires);
	return DemandeAvanceSalaires;
	}

	@Override
	public DemandeAvanceSalaire updateDemandeAvanceSalaire(Long id, DemandeAvanceSalaire dat) {
		 getDemandeAvanceSalaireById(id);
	        dat.setEmployerAvSalaireDemId(id);
	        return drep.save(dat);
		
	}
	
	

	@Override
	public Optional<DemandeAvanceSalaire> retrieveDemandeAvanceSalaire(Long id) {
		Optional<DemandeAvanceSalaire> DemandeAvanceSalaire = drep.findById((id));
		 l.log(Level.INFO, () ->"DemandeAvanceSalaire : " +DemandeAvanceSalaire);
			
		return DemandeAvanceSalaire;
	}

	@Override
	public DemandeAvanceSalaire getDemandeAvanceSalaireById(Long id) {
		Optional<DemandeAvanceSalaire> d = drep.findById(id);
		DemandeAvanceSalaire dat = new DemandeAvanceSalaire();
		if (d.isPresent()) {
			  dat= d.get();
			}
		return dat;
	}

	@Override
	public void deleteDemandeAvanceSalaireById(Long id) {
		{
			Optional<DemandeAvanceSalaire> d = drep.findById(id);

			DemandeAvanceSalaire DemandeAvanceSalaire = new DemandeAvanceSalaire();
			if (d.isPresent()) {
				DemandeAvanceSalaire= d.get();
				}
			
			drep.delete(DemandeAvanceSalaire);
		}
	}

	@Override
	public void acceptedemandeById(Long id) {
		DemandeAvanceSalaire d = drep.findById(id).get();
		d.setEmployerAvSalaireDemId(id);
		NotificationDemande n=new NotificationDemande();
		n.setBody("Votre  demande avance sur salaire de "+d.getEmployerAvSalaireDemDate() +"est confirmée !" );
		n.setTitre("Demande accepté");
		n.setDate(new Date());
		
		drep.save(d);
		ndr.save(n);
	}
	

	@Override
	public DemandeAvanceSalaire activerDemandeAvanceSalaire(Long id) {
		DemandeAvanceSalaire p=drep.findById(id).get();
        p.setActive(1);
        return drep.save(p);
	}

	@Override
	public DemandeAvanceSalaire desactiverDemandeAvanceSalaire(Long id) {
		 DemandeAvanceSalaire p=drep.findById(id).get();
	        p.setActive(0);
	        return drep.save(p);
	}

	@Override
	public List<DemandeAvanceSalaire> getDemandeAvanceSalaireListActive() {
		return (List<DemandeAvanceSalaire>)
				drep.findDemandeAvanceSalaireByActive(1);
	}

	@Override
	public List<DemandeAvanceSalaire> getDemandeAvanceSalaireListDesactive() {
		return (List<DemandeAvanceSalaire>)drep.findDemandeAvanceSalaireByActive(0);

}

	
	

}
