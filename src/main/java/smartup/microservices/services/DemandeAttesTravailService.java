package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeAttesTravail;



public interface DemandeAttesTravailService {
	
	public DemandeAttesTravail addDemandeAttesTravail(DemandeAttesTravail dat);
	public List<DemandeAttesTravail> retrieveAllDemandeAttesTravails();
	public DemandeAttesTravail updateDemandeAttesTravail(DemandeAttesTravail dat);
	public Optional<DemandeAttesTravail> retrieveDemandeAttesTravail(String id);
	public DemandeAttesTravail getDemandeAttesTravailById(int id);
	public void deleteDemandeAttesTravailById(int id);

}
