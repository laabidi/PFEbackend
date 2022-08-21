package smartup.microservices;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import smartup.microservices.entities.DemandeFraisProfes;
import smartup.microservices.repositories.DemandeInfoPersoRepository;
import smartup.microservices.services.DemandeCongeServiceImpl;
import smartup.microservices.services.DemandeFraisProfesServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
 class DemandeFraisProfesTest {
	
	private static final Logger l = LogManager.getLogger(DemandeCongeServiceImpl.class);
	@Autowired
	DemandeFraisProfesServiceImpl dfps;
	@Autowired
	DemandeInfoPersoRepository drep;
	
	@Test
	 void addDemandeFraisProfesTest()throws ParseException{
		DemandeFraisProfes e = new DemandeFraisProfes();
	  dfps.addDemandeFraisProfes(e);
	l.log(Level.INFO, () ->"retrieve DemandeFraisProfes : " +e);
	

	}
	 @Test
		void testRetrieveAllDemandeFraisProfess() {
			List<DemandeFraisProfes> d = dfps.retrieveAllDemandeFraisProfess();
		
			l.log(Level.INFO, () ->"retrieve Demande Frais Profes: " +d);
		}
  

}
