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

import smartup.microservices.entities.DemandeAttesTravail;
import smartup.microservices.services.DemandeAttesTravailServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("/api/smartRH")
public class DemandeAttesTravailController {
	
	@Autowired
	DemandeAttesTravailServiceImpl dats;
	
	@PostMapping("/add-DemandeAttesTravail")
	@ResponseBody
	public DemandeAttesTravail addDemandeAttesTravail (@RequestBody DemandeAttesTravail dc){
		DemandeAttesTravail DemandeAttesTravail = dats.addDemandeAttesTravail(dc);
		return DemandeAttesTravail;
		}
	
	
	// http://localhost:8081/api/smartRH/retrieve-all-DemandeAttesTravail
	@GetMapping("/retrieve-all-DemandeAttesTravail")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeAttesTravail> getDemandeAttesTravails() {
		List<DemandeAttesTravail> list = dats.retrieveAllDemandeAttesTravails();
		return list;
		}
	
	// http://localhost:8081/api/smartRH/retrieve-DemandeAttesTravail/{DemandeAttesTravail-id}
	@GetMapping("/retrieve-DemandeAttesTravail/{DemandeAttesTravail-id}")
	@ResponseBody
	public Optional<DemandeAttesTravail> retrieveDemandeAttesTravail(@PathVariable("DemandeAttesTravail-id") String DemandeAttesTravailId){
		return dats.retrieveDemandeAttesTravail(DemandeAttesTravailId);
		
	}
	
	// http://localhost:8081/api/smartRH/update-DemandeAttesTravail
	
	@PutMapping("/update-DemandeAttesTravail")
	@ResponseBody
	public DemandeAttesTravail modifyDemandeAttesTravail(@RequestBody DemandeAttesTravail DemandeAttesTravail){
		return dats.updateDemandeAttesTravail(DemandeAttesTravail);
	}
	// http://localhost:8081/api/smartRH/delete-DemandeAttesTravail
	
	@DeleteMapping("/delete-DemandeAttesTravail/{DemandeAttesTravail-id}")
	@ResponseBody
	public void deleteDemandeAttesTravail(@PathVariable ("DemandeAttesTravail-id") String DemandeAttesTravailId){
		dats.deleteDemandeAttesTravailById(1);
	}

}
