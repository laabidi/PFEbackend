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

import smartup.microservices.entities.DemandeFraisProfes;
import smartup.microservices.services.DemandeFraisProfesServiceImpl;


@RestController
@CrossOrigin
@RequestMapping
public class DemandeFraisProfesController {

	@Autowired
	DemandeFraisProfesServiceImpl dfps;
	
	@PostMapping("/add-DemandeFraisProfes")
	@ResponseBody
	public DemandeFraisProfes addDemandeFraisProfes (@RequestBody DemandeFraisProfes dc){
		return dfps.addDemandeFraisProfes(dc);
		}
	
	
	// http://localhost:8081/api/smartRH/retrieve-all-DemandeFraisProfes
	@GetMapping("/retrieve-all-DemandeFraisProfes")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeFraisProfes> getDemandeFraisProfess() {
		return dfps.retrieveAllDemandeFraisProfess();
		}
	
	
	@GetMapping("/retrieve-DemandeFraisProfes/{DemandeFraisProfes-id}")
	@ResponseBody
	public Optional<DemandeFraisProfes> retrieveDemandeFraisProfes(@PathVariable("DemandeFraisProfes-id") String DemandeFraisProfesId){
		return dfps.retrieveDemandeFraisProfes(DemandeFraisProfesId);
		
	}
	
	// http://localhost:8081/api/smartRH/update-DemandeFraisProfes
	
	@PutMapping("update-DemandeFraisProfes")
	@ResponseBody
	public DemandeFraisProfes modifyDemandeFraisProfes(@RequestBody DemandeFraisProfes DemandeFraisProfes){
		return dfps.updateDemandeFraisProfes(DemandeFraisProfes);
	}
	// http://localhost:8081/api/smartRH/delete-DemandeFraisProfes
	
	@DeleteMapping("/delete-DemandeFraisProfes/{DemandeFraisProfes-id}")
	@ResponseBody
	public void deleteDemandeFraisProfes(@PathVariable ("DemandeFraisProfes-id") String DemandeFraisProfesId){
		dfps.deleteDemandeFraisProfesById(1);
	}

}
