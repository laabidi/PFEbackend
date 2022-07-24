package smartup.microservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeConge;
import smartup.microservices.entities.NotificationDemande;
import smartup.microservices.repositories.DemandeCongeRepository;
import smartup.microservices.repositories.NotificationDemandeRepository;

@Service
public class DemandeCongeServiceImpl implements DemandeCongeService{

	
	@Autowired
	DemandeCongeRepository drep;
	@Autowired
	NotificationDemandeRepository ndr;
	
	private static final Logger l = LogManager.getLogger(DemandeCongeServiceImpl.class);

	@Override
	public DemandeConge addDemandeConge(DemandeConge dc) {
		dc.setEmployerCongesDemDate(new Date());
		dc.setActive("1");
		return drep.save(dc);
	}
	

	@Override
	public List<DemandeConge> retrieveAllDemandeConges() {
		
		List<DemandeConge> DemandeConges=(List<DemandeConge>) drep.findAll();
		l.log(Level.INFO, () ->"DemandeConge : " +DemandeConges);
	return DemandeConges;
}
	//@Override
    //public DemandeConge updateDemandeConge(int id, DemandeConge dc) {
        //getDemandeCongeById(id);
        //dc.setEmployerInfosRhDemTypeId(id);
       // return drep.save(dc);
    //}

	//@Override
	//public DemandeConge updateDemandeConge(DemandeConge dc) {
		
		//return drep.save(dc) ;
	//}
	 @Override
	    public DemandeConge updateDemandeConge(int id, DemandeConge dc) {
	        getDemandeCongeById(id);
	        dc.setEmployerInfosRhDemTypeId(id);
	        return drep.save(dc);
	    }

	@Override
	public Optional<DemandeConge> retrieveDemandeConge(int id) {
		
		Optional<DemandeConge> demandeConge = drep.findById(id);
		 l.log(Level.INFO, () ->"demandeConge : " +demandeConge);
			
		return demandeConge;
	}

	@Override
	public DemandeConge getDemandeCongeById(int id) {
		//return drep.findById(id).get();
		Optional<DemandeConge> d = drep.findById(id);
		DemandeConge dc = new DemandeConge();
		if (d.isPresent()) {
			  dc= d.get();
			}
		return dc;
	}

	@Override
	public void acceptedemandeById(int id) {
		DemandeConge d = drep.findById(id).get();
		d.setEmployerCongesDemStatut("1");
		NotificationDemande n=new NotificationDemande();
		n.setBody("Votre  demande de congé de "+d.getEmployerCongesDemDateDeb() +"a "+d.getEmployerCongesDemDateFin() +"est confirmée !" );
		n.setTitre("Demande accepté");
		n.setDate(new Date());
		
		drep.save(d);
		ndr.save(n);
	}
	
	@Override
	public void deleteDemandeCongeById(int id) {
		{
			Optional<DemandeConge> d = drep.findById(id);

			DemandeConge DemandeConge = new DemandeConge();
			if (d.isPresent()) {
				DemandeConge= d.get();
				}
			
			drep.delete(DemandeConge);
		}
	}

	@Override
	public DemandeConge activerDemandeConge(int id) {
		DemandeConge p=drep.findById(id).get();
        p.setActive("1");
        return drep.save(p);	}

	@Override
	public DemandeConge desactiverDemandeConge(int id) {
		 DemandeConge p=drep.findById(id).get();
	        p.setActive("0");
	        return drep.save(p);
	}

	@Override
	public List<DemandeConge> getDemandeCongeListActive() {
		return (List<DemandeConge>)
				drep.findDemandeCongeByActive(1);
	}

	@Override
	public List<DemandeConge> getDemandeCongeListDesactive() {
		return (List<DemandeConge>)drep.findDemandeCongeByActive(0);
	}

}
