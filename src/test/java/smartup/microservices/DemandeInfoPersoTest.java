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

import smartup.microservices.entities.DemandeInfoPerso;
import smartup.microservices.repositories.DemandeInfoPersoRepository;
import smartup.microservices.services.DemandeCongeServiceImpl;
import smartup.microservices.services.DemandeInfoPersoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemandeInfoPersoTest {
private static final Logger l = LogManager.getLogger(DemandeCongeServiceImpl.class);
	
	@Autowired
	DemandeInfoPersoServiceImpl dips;
	@Autowired
	DemandeInfoPersoRepository drep;
	
	@Test
	 void addDemandeInfoPersoTest()throws ParseException{
			
		
		DemandeInfoPerso e = new DemandeInfoPerso();
	  dips.addDemandeInfoPerso(e);
	l.log(Level.INFO, () ->"retrieve DemandeInfoPerso : " +e);
	

	}
	
	@Test
		void testRetrieveAllDemandeInfoPersos() {
			List<DemandeInfoPerso> d = dips.retrieveAllDemandeInfoPersos();
		
			l.log(Level.INFO, () ->"retrieve Demande Info Perso : " +d);
		}
	  
 
  
  

}
