package smartup.microservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import smartup.microservices.entities.DemandeInfoPerso;
import smartup.microservices.services.DemandeInfoPersoServiceImpl;

@RestController
@CrossOrigin
@RequestMapping
public class DemandeInfoPersoController {
	@Autowired
	DemandeInfoPersoServiceImpl dips;
	@PostMapping("/add-DemandeInfoPerso")
	@ResponseBody
	public DemandeInfoPerso addDemandeInfoPerso (@RequestBody DemandeInfoPerso dc){
		return dips.addDemandeInfoPerso(dc);
		}
	
	
	
	@GetMapping("/retrieve-all-DemandeInfoPerso")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeInfoPerso> getDemandeInfoPersos() {
		return dips.retrieveAllDemandeInfoPersos();
		}
	
	
	@GetMapping("/retrieve-DemandeInfoPerso/{DemandeInfoPerso-id}")
	@ResponseBody
	public Optional<DemandeInfoPerso> retrieveDemandeInfoPerso(@PathVariable("DemandeInfoPerso-id") String DemandeInfoPersoId){
		return dips.retrieveDemandeInfoPerso(DemandeInfoPersoId);
		
	}
	
	// http://localhost:8081/api/smartRH/update-DemandeInfoPerso
	
	@PutMapping("/update-DemandeInfoPerso")
	@ResponseBody
	public DemandeInfoPerso modifyDemandeInfoPerso(@RequestBody DemandeInfoPerso DemandeInfoPerso){
		return dips.updateDemandeInfoPerso(DemandeInfoPerso);
	}
	// http://localhost:8081/api/smartRH/delete-DemandeInfoPerso
	
	@DeleteMapping("/delete-DemandeInfoPerso/{DemandeInfoPerso-id}")
	@ResponseBody
	public void deleteDemandeInfoPerso(@PathVariable ("DemandeInfoPerso-id") String DemandeInfoPersoId){
		dips.deleteDemandeInfoPersoById(1);
	}

}
