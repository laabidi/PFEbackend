package smartup.microservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartup.microservices.entities.SoldeConge;
import smartup.microservices.repositories.SoldeCongeRepository;

@Service
public class SoldeCongeServiceImpl implements SoldeCongeService{

	@Autowired
	SoldeCongeRepository scr;
	private static final Logger l = LogManager.getLogger(SoldeCongeServiceImpl.class);

	@Override
	public SoldeConge addSoldeConge(SoldeConge sc) {
		return scr.save(sc);
	}

	@Override
	public List<SoldeConge> retrieveAllSoldeConges() {
		List<SoldeConge> soldes=(List<SoldeConge>) scr.findAll();
		for (SoldeConge solde: soldes)
		{
			l.info("solde: "+solde);
		}
		return soldes;
	}

	@Override
	public SoldeConge getSoldeCongeById(Long id) {
		Optional<SoldeConge> s = scr.findById(id);
		SoldeConge sc = new SoldeConge();
		if (s.isPresent()) {
			  sc= s.get();
			}
		return sc;
	}

}
