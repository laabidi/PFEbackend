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
	    public Object ActiverDemandeInfoPerso (@Validated @RequestBody DemandeInfoPersoDto DemandeInfoPersoDto , @PathVariable Long DemandeInfoPersoId) {
			DemandeInfoPerso DemandeInfoPerso = modelMapper.map(DemandeInfoPersoDto,DemandeInfoPerso.class);
			DemandeInfoPerso= dips.activerDemandeInfoPerso(DemandeInfoPersoId);
	        DemandeInfoPersoDto = modelMapper.map(DemandeInfoPerso,DemandeInfoPersoDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeInfoPersoDto);

	    }

	    @PutMapping("/DemandeInfoPersosDesactives/{DemandeInfoPersoId}")
	    public Object DesactiverDemandeInfoPerso (@Validated @RequestBody DemandeInfoPersoDto DemandeInfoPersoDto , @PathVariable Long DemandeInfoPersoId) {
	    	DemandeInfoPerso DemandeInfoPerso = modelMapper.map(DemandeInfoPersoDto,DemandeInfoPerso.class);
	    	DemandeInfoPerso= dips.desactiverDemandeInfoPerso(DemandeInfoPersoId);
	        DemandeInfoPersoDto = modelMapper.map(DemandeInfoPerso,DemandeInfoPersoDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeInfoPersoDto);

	    }

		@PostMapping("/accepteDemandeInfoPerso/{DemandeInfoPersoId}")
		@ResponseBody
		public void acceptedemandeById(@PathVariable Long DemandeInfoPersoId) {
			dips.acceptedemandeById(DemandeInfoPersoId);
		}
	 
	@PostMapping("/addDemandeInfoPerso")
	@ResponseBody
	public Object addDemandeInfoPerso (@RequestBody DemandeInfoPersoDto datDto){
		DemandeInfoPerso dat = modelMapper.map(datDto, DemandeInfoPerso.class);
     dat = dips.addDemandeInfoPerso(dat);
     datDto = modelMapper.map(dat, DemandeInfoPersoDto.class);
     return ResponseEntity.status(HttpStatus.CREATED).body(datDto);
 }
		
	
	
	
	@GetMapping("/retrieveAllDemandeInfoPerso")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeInfoPerso> getDemandeInfoPersos() {
		List<DemandeInfoPerso> list = dips.retrieveAllDemandeInfoPersos();
		return list;
		}
	
	
	@GetMapping("/retrieveDemandeInfoPerso/{DemandeInfoPersoId}")
	@ResponseBody
	
	public Object DemandeInfoPerso(@PathVariable Long DemandeInfoPersoId) {
		DemandeInfoPerso dip = dips.getDemandeInfoPersoById(DemandeInfoPersoId) ;
		DemandeInfoPersoDto datDto= modelMapper.map(dip, DemandeInfoPersoDto.class);
 return ResponseEntity.status(HttpStatus.OK).body(datDto);
	}
	
	
	
	@PutMapping("/updateDemandeInfoPerso/{DemandeInfoPersoId}")
	@ResponseBody
	 public Object UpdateDemandeInfoPerso (@Validated @RequestBody DemandeInfoPersoDto DemandeInfoPersoDto , @PathVariable Long DemandeInfoPersoId) {
				DemandeInfoPerso DemandeInfoPerso = modelMapper.map(DemandeInfoPersoDto,DemandeInfoPerso.class);
				DemandeInfoPerso= dips.updateDemandeInfoPerso( DemandeInfoPerso);
		      DemandeInfoPersoDto = modelMapper.map(DemandeInfoPerso,DemandeInfoPersoDto.class);
		       return ResponseEntity.status(HttpStatus.CREATED).body(DemandeInfoPersoDto);
		       }

	
	
	@DeleteMapping("/deleteDemandeInfoPerso/{DemandeInfoPersoId}")
	@ResponseBody
	public void deleteDemandeInfoPerso(@PathVariable ("DemandeInfoPerso-id") Long DemandeInfoPersoId){
		dips.deleteDemandeInfoPersoById(DemandeInfoPersoId);
	}

}
