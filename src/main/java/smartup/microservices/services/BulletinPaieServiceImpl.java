package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.BulletinPaie;
import smartup.microservices.repositories.BulletinPaieRepository;

@Service
public class BulletinPaieServiceImpl implements BulletinPaieService{
	
	
	@Autowired
	BulletinPaieRepository bpr;
	private static final Logger l = LogManager.getLogger(BulletinPaieServiceImpl.class);
	
	@Override
	public BulletinPaie addBulletinPaie(BulletinPaie bp) {
	
		return bpr.save(bp);
	}

	@Override
	public List<BulletinPaie> retrieveAllBulletinPaies() {
		
		List<BulletinPaie> bulletins=bpr.findAll();
		for (BulletinPaie bulletin: bulletins)
		{
			l.info("bulletin: "+bulletin);
		}
		return bulletins;
	}
	

	@Override
	public BulletinPaie getBulletinPaieById(Long id) {
	
		Optional<BulletinPaie> b = bpr.findById(id);
		BulletinPaie bp = new BulletinPaie();
		if (b.isPresent()) {
			  bp= b.get();
			}
		return bp;
	}

}
