package smartup.microservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import smartup.microservices.entities.SoldeConge;
import smartup.microservices.services.SoldeCongeServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("/api/smartrh")
public class SoldeCongeController {

	@Autowired
	SoldeCongeServiceImpl scs;
	
	@PostMapping("/addSoldeConge")
	@ResponseBody
	public SoldeConge addSoldeConge (@RequestBody SoldeConge app){
		return scs.addSoldeConge(app);
		}
	
	
	
	@GetMapping("/retrieveAllSoldeConges")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<SoldeConge> getConges() {
		return scs.retrieveAllSoldeConges();
		}
	
	
	@GetMapping("/retrieveSoldeConge/{soldeCongeId}")
	@ResponseBody
	public Object retrieveSoldeConge(@PathVariable("soldeCongeId") Long soldeCongeId){
		return scs.getSoldeCongeById(soldeCongeId);
		
	}
}
