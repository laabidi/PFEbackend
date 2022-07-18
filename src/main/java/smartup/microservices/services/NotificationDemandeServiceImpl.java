package smartup.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.NotificationDemande;
import smartup.microservices.repositories.NotificationDemandeRepository;

@Service
public class NotificationDemandeServiceImpl implements NotificationDemandeService{

	@Autowired
	NotificationDemandeRepository ndr;

	@Override
	public NotificationDemande ajouterNotification(NotificationDemande n) {
		
		return ndr.save(n);
	}

	@Override
	public List<NotificationDemande> getAllNotification() {

		return ndr.findAll();
	}

	@Override
	public NotificationDemande getNotificationById(Long id) {
		
		return ndr.getById(id);
	}

}
