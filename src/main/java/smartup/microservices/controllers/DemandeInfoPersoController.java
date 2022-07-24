package smartup.microservices.controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import smartup.microservices.dto.DemandeInfoPersoDto;
import smartup.microservices.entities.DemandeInfoPerso;
import smartup.microservices.services.DemandeInfoPersoServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/smartrh")
public class DemandeInfoPersoController {
	@Autowired
	DemandeInfoPersoServiceImpl dips;
	@Autowired
    private ModelMapper modelMapper ;
	
	 @GetMapping("/DemandeInfoPersoActives")
	    public Object DemandeInfoPersolistActive() {
	        List<DemandeInfoPerso> DemandeInfoPersos= dips.getDemandeInfoPersoListActive();
	        Type listType = new TypeToken<List<DemandeInfoPersoDto>>() {}.getType() ;
	        List <DemandeInfoPersoDto> DemandeInfoPersoDtos= modelMapper.map(DemandeInfoPersos,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeInfoPersoDtos);
	    }
	 @GetMapping("/DemandeInfoPersoDesactives")
	    public Object DemandeInfoPersolistDesactive() {
	        List<DemandeInfoPerso> DemandeInfoPersos= dips.getDemandeInfoPersoListDesactive();
	        Type listType = new TypeToken<List<DemandeInfoPersoDto>>() {}.getType() ;
	        List <DemandeInfoPerso> DemandeInfoPersoDtos= modelMapper.map(DemandeInfoPersos,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeInfoPersoDtos);
	    }
	 @PutMapping("/DemandeInfoPersosActives/{DemandeInfoPersoId}")
	    public Object ActiverDemandeInfoPerso (@Validated @RequestBody DemandeInfoPersoDto DemandeInfoPersoDto , @PathVariable Long idDemande) {
			DemandeInfoPerso DemandeInfoPerso = modelMapper.map(DemandeInfoPersoDto,DemandeInfoPerso.class);
			DemandeInfoPerso= dips.activerDemandeInfoPerso(idDemande);
	        DemandeInfoPersoDto = modelMapper.map(DemandeInfoPerso,DemandeInfoPersoDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeInfoPersoDto);

	    }

	    @PutMapping("/DemandeInfoPersosDesactives/{DemandeInfoPersoId}")
	    public Object DesactiverDemandeInfoPerso (@Validated @RequestBody DemandeInfoPersoDto DemandeInfoPersoDto , @PathVariable Long idDemande) {
	    	DemandeInfoPerso DemandeInfoPerso = modelMapper.map(DemandeInfoPersoDto,DemandeInfoPerso.class);
	    	DemandeInfoPerso= dips.desactiverDemandeInfoPerso(idDemande);
	        DemandeInfoPersoDto = modelMapper.map(DemandeInfoPerso,DemandeInfoPersoDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeInfoPersoDto);

	    }

		@PostMapping("/acceptedemande/{DemandeInfoPersoId}")
		@ResponseBody
		public void acceptedemandeById(@PathVariable Long DemandeInfoPersoId) {
			dips.acceptedemandeById(DemandeInfoPersoId);
		}
	 
	@PostMapping("/add-DemandeInfoPerso")
	@ResponseBody
	public Object addDemandeInfoPerso (@RequestBody DemandeInfoPersoDto datDto){
		DemandeInfoPerso dat = modelMapper.map(datDto, DemandeInfoPerso.class);
     dat = dips.addDemandeInfoPerso(dat);
     datDto = modelMapper.map(dat, DemandeInfoPersoDto.class);
     return ResponseEntity.status(HttpStatus.CREATED).body(datDto);
 }
		
	
	
	
	@GetMapping("/retrieve-all-DemandeInfoPerso")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeInfoPerso> getDemandeInfoPersos() {
		List<DemandeInfoPerso> list = dips.retrieveAllDemandeInfoPersos();
		return list;
		}
	
	
	@GetMapping("/retrieve-DemandeInfoPerso/{DemandeInfoPerso-id}")
	@ResponseBody
	//public Optional<DemandeInfoPerso> retrieveDemandeInfoPerso(@PathVariable("DemandeInfoPerso-id") Long DemandeInfoPersoId){
	//	return dips.retrieveDemandeInfoPerso(DemandeInfoPersoId);
	public Object DemandeInfoPerso(@PathVariable Long id ) {
		DemandeInfoPerso produit = dips.getDemandeInfoPersoById(id) ;
		DemandeInfoPersoDto datDto= modelMapper.map(produit, DemandeInfoPersoDto.class);
 return ResponseEntity.status(HttpStatus.OK).body(datDto);
	}
	
	
	
	@PutMapping("/update-DemandeInfoPerso")
	@ResponseBody
	 public Object UpdateDemandeInfoPerso (@Validated @RequestBody DemandeInfoPersoDto DemandeInfoPersoDto , @PathVariable Long employerAttesTravailDemId) {
				DemandeInfoPerso DemandeInfoPerso = modelMapper.map(DemandeInfoPersoDto,DemandeInfoPerso.class);
				DemandeInfoPerso= dips.updateDemandeInfoPerso( DemandeInfoPerso);
		      DemandeInfoPersoDto = modelMapper.map(DemandeInfoPerso,DemandeInfoPersoDto.class);
		       return ResponseEntity.status(HttpStatus.CREATED).body(DemandeInfoPersoDto);
		       }

	
	
	@DeleteMapping("/delete-DemandeInfoPerso/{DemandeInfoPerso-id}")
	@ResponseBody
	public void deleteDemandeInfoPerso(@PathVariable ("DemandeInfoPerso-id") String DemandeInfoPersoId){
		dips.deleteDemandeInfoPersoById(1);
	}

}
