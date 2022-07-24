package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import smartup.microservices.entities.DemandeAttesTravail;



public interface DemandeAttesTravailService {
	
	public DemandeAttesTravail addDemandeAttesTravail(DemandeAttesTravail dat);
	public List<DemandeAttesTravail> retrieveAllDemandeAttesTravails();
	public DemandeAttesTravail updateDemandeAttesTravail(DemandeAttesTravail dat);
	public Optional<DemandeAttesTravail> retrieveDemandeAttesTravail(Long id);
	public DemandeAttesTravail getDemandeAttesTravailById(Long id);
	public void deleteDemandeAttesTravailById(int id);
	void acceptedemandeById(Long id);
	DemandeAttesTravail activerDemandeAttesTravail(Long id);
	DemandeAttesTravail desactiverDemandeAttesTravail(Long id);
	List<DemandeAttesTravail> getDemandeAttesTravailListActive();
    List<DemandeAttesTravail> getDemandeAttesTravailListDesactive();
}
