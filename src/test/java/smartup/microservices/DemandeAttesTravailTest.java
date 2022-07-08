package smartup.microservices;



import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import smartup.microservices.entities.DemandeAttesTravail;
import smartup.microservices.repositories.DemandeAttestTravailRepository;
import smartup.microservices.services.DemandeAttesTravailServiceImpl;
import smartup.microservices.services.DemandeCongeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemandeAttesTravailTest {

private static final Logger l = LogManager.getLogger(DemandeCongeServiceImpl.class);
	
	@Autowired
	DemandeAttesTravailServiceImpl dats;
	@Autowired
	DemandeAttestTravailRepository drep;
	
	@Test
	 void addDemandeCongeTest()throws ParseException{
			
		
	  DemandeAttesTravail e = new DemandeAttesTravail();
	  dats.addDemandeAttesTravail(e);
	l.log(Level.INFO, () ->"retrieve DemandeAttestTravail : " +e);
	

	}
 
  
  
}
