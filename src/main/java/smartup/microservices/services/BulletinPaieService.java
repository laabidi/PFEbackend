package smartup.microservices.services;

import java.util.List;

import smartup.microservices.entities.BulletinPaie;

public interface BulletinPaieService {
	public BulletinPaie addBulletinPaie(BulletinPaie bp);
	public List<BulletinPaie> retrieveAllBulletinPaies();
	public BulletinPaie getBulletinPaieById(Long id);
}
