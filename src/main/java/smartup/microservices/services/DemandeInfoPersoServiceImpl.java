package smartup.microservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeInfoPerso;
import smartup.microservices.entities.NotificationDemande;
import smartup.microservices.repositories.DemandeInfoPersoRepository;
import smartup.microservices.repositories.NotificationDemandeRepository;



@Service
public class DemandeInfoPersoServiceImpl implements DemandeInfoPersoSevice {
	@Autowired
	DemandeInfoPersoRepository dipr;
	@Autowired
	NotificationDemandeRepository ndr;
	
	private static final Logger l = LogManager.getLogger(DemandeInfoPersoServiceImpl.class);

	@Override
	public DemandeInfoPerso addDemandeInfoPerso(DemandeInfoPerso dat) {
		
		return dipr.save(dat);
	}

	@Override
	public List<DemandeInfoPerso> retrieveAllDemandeInfoPersos() {
		List<DemandeInfoPerso> DemandeInfoPersos=(List<DemandeInfoPerso>) dipr.findAll();
		l.log(Level.INFO, () ->"DemandeInfoPerso : " +DemandeInfoPersos);
	return DemandeInfoPersos;
	}

	@Override
	public DemandeInfoPerso updateDemandeInfoPerso(DemandeInfoPerso dat) {
		return dipr.save(dat) ;
	}

	@Override
	public Optional<DemandeInfoPerso> retrieveDemandeInfoPerso(Long id) {
		Optional<DemandeInfoPerso> DemandeInfoPerso = dipr.findById((id));
		 l.log(Level.INFO, () ->"DemandeInfoPerso : " +DemandeInfoPerso);
			
		return DemandeInfoPerso;
	}

	@Override
	public DemandeInfoPerso getDemandeInfoPersoById(Long id) {
		Optional<DemandeInfoPerso> d = dipr.findById(1L);
		DemandeInfoPerso dat = new DemandeInfoPerso();
		if (d.isPresent()) {
			  dat= d.get();
			}
		return dat;
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

	@Override
	public void acceptedemandeById(Long id) {
		DemandeInfoPerso d = dipr.findById(id).get();
		d.setEmployerInfosPersoRhDemLibelle(1);
		NotificationDemande n=new NotificationDemande();
		n.setBody("Votre  demande information personnelle de "+d.getEmployerInfosPersoRhDemUsername() +"est confirmée !" );
		n.setTitre("Demande accepté");
		n.setDate(new Date());
		
		dipr.save(d);
		ndr.save(n);
	}
	

	@Override
	public DemandeInfoPerso activerDemandeInfoPerso(Long id) {
		DemandeInfoPerso p=dipr.findById(id).get();
        p.setActive(1);
        return dipr.save(p);
	}

	@Override
	public DemandeInfoPerso desactiverDemandeInfoPerso(Long id) {
		 DemandeInfoPerso p=dipr.findById(id).get();
	        p.setActive(0);
	        return dipr.save(p);
	}

	@Override
	public List<DemandeInfoPerso> getDemandeInfoPersoListActive() {
		return (List<DemandeInfoPerso>)
				dipr.findDemandeInfoPersoByActive(1);
	}

	@Override
	public List<DemandeInfoPerso> getDemandeInfoPersoListDesactive() {
		return (List<DemandeInfoPerso>)dipr.findDemandeInfoPersoByActive(0);

}

}
