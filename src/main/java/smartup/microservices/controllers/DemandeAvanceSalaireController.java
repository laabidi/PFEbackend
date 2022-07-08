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

import smartup.microservices.entities.DemandeAvanceSalaire;
import smartup.microservices.services.DemandeAvanceSalaireServiceImpl;




@RestController
@CrossOrigin
@RequestMapping("/api/smartRH")
public class DemandeAvanceSalaireController {
	@Autowired
	DemandeAvanceSalaireServiceImpl dass;
	@PostMapping("/add-DemandeAvanceSalaire")
	@ResponseBody
	
		public DemandeAvanceSalaire addDemandeAvanceSalaire (@RequestBody DemandeAvanceSalaire das){
			DemandeAvanceSalaire DemandeAvanceSalaire = dass.addDemandeAvanceSalaire(das);
			return DemandeAvanceSalaire;
			}
	
	
	// http://localhost:8081/api/smartRH/retrieve-all-DemandeAvanceSalaires
	@GetMapping("/retrieve-all-DemandeAvanceSalaires")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeAvanceSalaire> getDemandeAvanceSalaires() {
		List<DemandeAvanceSalaire> list = dass.retrieveAllDemandeAvanceSalaires();
		return list;
		}
	
	// http://localhost:8081/api/smartRH/retrieve-DemandeAvanceSalaire/{DemandeAvanceSalaire-id}
	@GetMapping("/retrieve-DemandeAvanceSalaire/{DemandeAvanceSalaire-id}")
	@ResponseBody
	public Optional<DemandeAvanceSalaire> retrieveDemandeAvanceSalaire(@PathVariable("DemandeAvanceSalaire-id") String DemandeAvanceSalaireId){
		return dass.retrieveDemandeAvanceSalaire(DemandeAvanceSalaireId);
		
	}
	
	// http://localhost:8081/api/smartRH/update-DemandeAvanceSalaire
	
	@PutMapping("update-DemandeAvanceSalaire")
	@ResponseBody
	public DemandeAvanceSalaire modifyDemandeAvanceSalaire(@RequestBody DemandeAvanceSalaire DemandeAvanceSalaire){
		return dass.updateDemandeAvanceSalaire(DemandeAvanceSalaire);
	}
	// http://localhost:8081/api/smartRH/delete-DemandeAvanceSalaire
	
	@DeleteMapping("/delete-DemandeAvanceSalaire/{DemandeAvanceSalaire-id}")
	@ResponseBody
	public void deleteDemandeAvanceSalaire(@PathVariable ("DemandeAvanceSalaire-id") String DemandeAvanceSalaireId){
		dass.deleteDemandeAvanceSalaireById(1);
	}

}
