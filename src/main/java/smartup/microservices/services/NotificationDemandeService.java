package smartup.microservices.services;

import java.util.List;

import smartup.microservices.entities.NotificationDemande;

public interface NotificationDemandeService  {
	
	public NotificationDemande ajouterNotification(NotificationDemande n);
	public List<NotificationDemande> getAllNotification();
	public NotificationDemande getNotificationById(Long id);
}
