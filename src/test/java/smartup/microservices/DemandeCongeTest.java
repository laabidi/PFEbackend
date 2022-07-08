package smartup.microservices;






import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import smartup.microservices.entities.DemandeConge;
import smartup.microservices.repositories.DemandeCongeRepository;
import smartup.microservices.services.DemandeCongeServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class DemandeCongeTest {
	
private static final Logger l = LogManager.getLogger(DemandeCongeServiceImpl.class);
	
	@Autowired
	DemandeCongeServiceImpl dcs;
	@Autowired
	DemandeCongeRepository drep;

	
	
	  @Test
		void addDemandeCongeTest()throws ParseException{
				
			
		  DemandeConge e = new DemandeConge();
		  dcs.addDemandeConge(e);
		l.log(Level.INFO, () ->"ajout DemandeConge : " +e);
		

		}
	  
	  
	  
	
	  
	  @Test
		void testRetrieveAllDemandeConges() {
			List<DemandeConge> d = dcs.retrieveAllDemandeConges();
		
			l.log(Level.INFO, () ->"retrieve Demande Conge : " +d);
		}
	  
	 @Test
	 void testUpdateDemandeConge() {
			DemandeConge e= dcs.getDemandeCongeById(1);
			e.setEmployerCongesDemStatut("UP");
			DemandeConge es= dcs.updateDemandeConge(e);
			Assert.assertEquals(e.getEmployerCongesDemStatut(), es.getEmployerCongesDemStatut());
			}	  
	  
	  
	  
	 @Test
		void testdeleteDemandeConge(){
		drep.deleteById(1L);	
		}
		  
		
		}
	 
	   
			
	 

