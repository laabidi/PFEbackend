package smartup.microservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeAttesTravail;
import smartup.microservices.entities.NotificationDemande;
import smartup.microservices.repositories.DemandeAttestTravailRepository;
import smartup.microservices.repositories.NotificationDemandeRepository;

@Service
public class DemandeAttesTravailServiceImpl implements DemandeAttesTravailService{
	
	@Autowired
	DemandeAttestTravailRepository drep;
	@Autowired
	NotificationDemandeRepository ndr;
	
	private static final Logger l = LogManager.getLogger(DemandeAttesTravailServiceImpl.class);
	@Override
	public DemandeAttesTravail addDemandeAttesTravail(DemandeAttesTravail dat) {
		
		return drep.save(dat);
	}

	@Override
	public List<DemandeAttesTravail> retrieveAllDemandeAttesTravails() {
		List<DemandeAttesTravail> DemandeAttesTravails=(List<DemandeAttesTravail>) drep.findAll();
		l.log(Level.INFO, () ->"DemandeAttesTravail : " +DemandeAttesTravails);
	return DemandeAttesTravails;
	}

	
	@Override
    public DemandeAttesTravail updateDemandeAttesTravail(Long id, DemandeAttesTravail dat ) {
        getDemandeAttesTravailById(id);
        dat.setEmployerAttesTravailDemId(id);
        return drep.save(dat);
    }

	@Override
	public Optional<DemandeAttesTravail> retrieveDemandeAttesTravail(Long id) {
		Optional<DemandeAttesTravail> DemandeAttesTravail = drep.findById((id));
		 l.log(Level.INFO, () ->"DemandeAttesTravail : " +DemandeAttesTravail);
			
		return DemandeAttesTravail;
	}

	@Override
	public DemandeAttesTravail getDemandeAttesTravailById(Long id) {
		Optional<DemandeAttesTravail> d = drep.findById(id);
		DemandeAttesTravail dat = new DemandeAttesTravail();
		if (d.isPresent()) {
			  dat= d.get();
			}
		return dat;
	}

	@Override
	public void deleteDemandeAttesTravailById(Long id) {
		{
			Optional<DemandeAttesTravail> d = drep.findById(id);

			DemandeAttesTravail DemandeAttesTravail = new DemandeAttesTravail();
			if (d.isPresent()) {
				DemandeAttesTravail= d.get();
				}
			
			drep.delete(DemandeAttesTravail);
		}
	}

	@Override
	public void acceptedemandeById(Long id) {
		DemandeAttesTravail d = drep.findById(id).get();
		d.setEmployerAttesTravailStatus("1");
		NotificationDemande n=new NotificationDemande();
		n.setBody("Votre  demande Attestation de travail  de "+d.getEmployerAttesTravailDemDate() +"est confirmée !" );
		n.setTitre("Demande accepté");
		n.setDate(new Date());
		
		drep.save(d);
		ndr.save(n);
	}
	

	@Override
	public DemandeAttesTravail activerDemandeAttesTravail(Long id) {
		DemandeAttesTravail p=drep.findById(id).get();
        p.setActive(1);
        return drep.save(p);
	}

	@Override
	public DemandeAttesTravail desactiverDemandeAttesTravail(Long id) {
		 DemandeAttesTravail p=drep.findById(id).get();
	        p.setActive(0);
	        return drep.save(p);
	}

	@Override
	public List<DemandeAttesTravail> getDemandeAttesTravailListActive() {
		return (List<DemandeAttesTravail>)
				drep.findDemandeAttesTravailByActive(1);
	}

	@Override
	public List<DemandeAttesTravail> getDemandeAttesTravailListDesactive() {
		return (List<DemandeAttesTravail>)drep.findDemandeAttesTravailByActive(0);

}

	
}
