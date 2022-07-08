package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeAttesTravail;
import smartup.microservices.repositories.DemandeAttestTravailRepository;

@Service
public class DemandeAttesTravailServiceImpl implements DemandeAttesTravailService{
	
	@Autowired
	DemandeAttestTravailRepository drep;

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
	public DemandeAttesTravail updateDemandeAttesTravail(DemandeAttesTravail dat) {
		return drep.save(dat) ;
	}

	@Override
	public Optional<DemandeAttesTravail> retrieveDemandeAttesTravail(String id) {
		Optional<DemandeAttesTravail> DemandeAttesTravail = drep.findById(Long.parseLong(id));
		 l.log(Level.INFO, () ->"DemandeAttesTravail : " +DemandeAttesTravail);
			
		return DemandeAttesTravail;
	}

	@Override
	public DemandeAttesTravail getDemandeAttesTravailById(int id) {
		Optional<DemandeAttesTravail> d = drep.findById(1L);
		DemandeAttesTravail dat = new DemandeAttesTravail();
		if (d.isPresent()) {
			  dat= d.get();
			}
		return dat;
	}

	@Override
	public void deleteDemandeAttesTravailById(int id) {
		{
			Optional<DemandeAttesTravail> d = drep.findById(1L);

			DemandeAttesTravail DemandeAttesTravail = new DemandeAttesTravail();
			if (d.isPresent()) {
				DemandeAttesTravail= d.get();
				}
			
			drep.delete(DemandeAttesTravail);
		}
	}

}
