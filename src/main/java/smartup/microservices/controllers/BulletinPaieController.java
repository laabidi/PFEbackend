package smartup.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import smartup.microservices.entities.BulletinPaie;
import smartup.microservices.services.BulletinPaieServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/smartrh")
public class BulletinPaieController {
	
	@Autowired
	BulletinPaieServiceImpl bps;
	
	@PostMapping("/addBulletinPaie")
	@ResponseBody
	
	public BulletinPaie addBulletinPaie (@RequestBody BulletinPaie bulletinPaie){
		return bps.addBulletinPaie(bulletinPaie);
	}
		
		
	
	
	@GetMapping("/retrieveAllBulletinPaies")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<BulletinPaie> getBulletinPaies() {
		return bps.retrieveAllBulletinPaies();
		}
	
	
	@GetMapping("/retrieveBulletinPaie/{bulletinPaieId}")
	@ResponseBody
	public Object retrieveBulletinPaie(@PathVariable("bulletinPaieId") Long bulletinPaieId){
		return bps.getBulletinPaieById(bulletinPaieId);
		
	}
}
