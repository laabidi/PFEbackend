package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.DemandeAvanceSalaire;
import smartup.microservices.repositories.DemandeAvanceSalaireRepository;

@Service
public class DemandeAvanceSalaireServiceImpl implements DemandeAvanceSalaireService{

	@Autowired
	DemandeAvanceSalaireRepository drep;
	
	private static final Logger l = LogManager.getLogger(DemandeAvanceSalaireServiceImpl.class);
	@Override
	public DemandeAvanceSalaire addDemandeAvanceSalaire(DemandeAvanceSalaire das) {
		return drep.save(das);
	}

	@Override
	public List<DemandeAvanceSalaire> retrieveAllDemandeAvanceSalaires() {
		List<DemandeAvanceSalaire> DemandeAvanceSalaires=(List<DemandeAvanceSalaire>) drep.findAll();
		l.log(Level.INFO, () ->"DemandeAvanceSalaire : " +DemandeAvanceSalaires);
	return DemandeAvanceSalaires;
	}

	@Override
	public DemandeAvanceSalaire updateDemandeAvanceSalaire(DemandeAvanceSalaire das) {
		return drep.save(das) ;
	}

	@Override
	public Optional<DemandeAvanceSalaire> retrieveDemandeAvanceSalaire(String id) {
		Optional<DemandeAvanceSalaire> DemandeAvanceSalaire = drep.findById(Long.parseLong(id));
		 l.log(Level.INFO, () ->"DemandeAvanceSalaire : " +DemandeAvanceSalaire);
			
		return DemandeAvanceSalaire;
	}

	@Override
	public DemandeAvanceSalaire getDemandeAvanceSalaireById(int id) {
		Optional<DemandeAvanceSalaire> d = drep.findById(1L);
		DemandeAvanceSalaire das = new DemandeAvanceSalaire();
		if (d.isPresent()) {
			  das= d.get();
			}
		return das;
	}

	@Override
	public void deleteDemandeAvanceSalaireById(int id) {
		{
			Optional<DemandeAvanceSalaire> d = drep.findById(1L);

			DemandeAvanceSalaire DemandeAvanceSalaire = new DemandeAvanceSalaire();
			if (d.isPresent()) {
				DemandeAvanceSalaire= d.get();
				}
			
			drep.delete(DemandeAvanceSalaire);
		}
	}

}
