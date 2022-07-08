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

import smartup.microservices.entities.DemandeConge;
import smartup.microservices.services.DemandeCongeServiceImpl;


@RestController
@CrossOrigin("*")

@RequestMapping("/api/smartrh")
public class DemandeCongeController {

	
	@Autowired
	DemandeCongeServiceImpl dcs;
	
	
	@PostMapping("/add-DemandeConge")
	@ResponseBody
	public DemandeConge addDemandeConge (@RequestBody DemandeConge dc){
		DemandeConge DemandeConge = dcs.addDemandeConge(dc);
		return DemandeConge;
		}
	
	
	// http://localhost:8081/api/smartRH/retrieve-all-DemandeConges
	@GetMapping("/retrieve-all-DemandeConges")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeConge> getDemandeConges() {
		List<DemandeConge> list = dcs.retrieveAllDemandeConges();
		return list;
		}
	
	// http://localhost:8081/api/smartRH/retrieve-DemandeConge/{DemandeConge-id}
	@GetMapping("/retrieve-DemandeConge/{DemandeConge-id}")
	@ResponseBody
	public Optional<DemandeConge> retrieveDemandeConge(@PathVariable("DemandeConge-id") String DemandeCongeId){
		return dcs.retrieveDemandeConge(DemandeCongeId);
		
	}
	
	// http://localhost:8081/api/smartRH/update-DemandeConge
	
	@PutMapping("/update-DemandeConge")
	@ResponseBody
	public DemandeConge modifyDemandeConge(@RequestBody DemandeConge DemandeConge){
		return dcs.updateDemandeConge(DemandeConge);
	}
	// http://localhost:8081/api/smartRH/delete-DemandeConge
	
	@DeleteMapping("/delete-DemandeConge/{DemandeConge-id}")
	@ResponseBody
	public void deleteDemandeConge(@PathVariable ("DemandeConge-id") String DemandeCongeId){
		dcs.deleteDemandeCongeById(1);
	}
}
