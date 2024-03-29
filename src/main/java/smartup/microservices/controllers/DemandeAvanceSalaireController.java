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

import smartup.microservices.dto.DemandeAvanceSalaireDto;
import smartup.microservices.entities.DemandeAvanceSalaire;
import smartup.microservices.services.DemandeAvanceSalaireServiceImpl;




@RestController
@CrossOrigin
@RequestMapping("/api/smartrh")
public class DemandeAvanceSalaireController {
	@Autowired
	DemandeAvanceSalaireServiceImpl dass;
	@Autowired
    private ModelMapper modelMapper ;
	
	 @GetMapping("/DemandeAvanceSalaireActives")
	    public Object DemandeAvanceSalairelistActive() {
	        List<DemandeAvanceSalaire> DemandeAvanceSalaires= dass.getDemandeAvanceSalaireListActive();
	        Type listType = new TypeToken<List<DemandeAvanceSalaireDto>>() {}.getType() ;
	        List <DemandeAvanceSalaireDto> DemandeAvanceSalaireDtos= modelMapper.map(DemandeAvanceSalaires,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeAvanceSalaireDtos);
	    }
	 @GetMapping("/DemandeAvanceSalaireDesactives")
	    public Object DemandeAvanceSalairelistDesactive() {
	        List<DemandeAvanceSalaire> DemandeAvanceSalaires= dass.getDemandeAvanceSalaireListDesactive();
	        Type listType = new TypeToken<List<DemandeAvanceSalaireDto>>() {}.getType() ;
	        List <DemandeAvanceSalaire> DemandeAvanceSalaireDtos= modelMapper.map(DemandeAvanceSalaires,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeAvanceSalaireDtos);
	    }
	 @PutMapping("/DemandeAvanceSalairesActives/{DemandeAvanceSalaireId}")
	    public Object ActiverDemandeAvanceSalaire (@Validated @RequestBody DemandeAvanceSalaireDto DemandeAvanceSalaireDto , @PathVariable Long DemandeAvanceSalaireId) {
			DemandeAvanceSalaire DemandeAvanceSalaire = modelMapper.map(DemandeAvanceSalaireDto,DemandeAvanceSalaire.class);
			DemandeAvanceSalaire= dass.activerDemandeAvanceSalaire(DemandeAvanceSalaireId);
	        DemandeAvanceSalaireDto = modelMapper.map(DemandeAvanceSalaire,DemandeAvanceSalaireDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeAvanceSalaireDto);

	    }

	    @PutMapping("/DemandeAvanceSalairesDesactives/{DemandeAvanceSalaireId}")
	    public Object DesactiverDemandeAvanceSalaire (@Validated @RequestBody DemandeAvanceSalaireDto DemandeAvanceSalaireDto , @PathVariable Long DemandeAvanceSalaireId) {
	    	DemandeAvanceSalaire DemandeAvanceSalaire = modelMapper.map(DemandeAvanceSalaireDto,DemandeAvanceSalaire.class);
	    	DemandeAvanceSalaire= dass.desactiverDemandeAvanceSalaire(DemandeAvanceSalaireId);
	        DemandeAvanceSalaireDto = modelMapper.map(DemandeAvanceSalaire,DemandeAvanceSalaireDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeAvanceSalaireDto);

	    }

		@PostMapping("/accepteDemandeAvanceSalaires/{DemandeAvanceSalaireId}")
		@ResponseBody
		public void acceptedemandeById(@PathVariable Long DemandeAvanceSalaireId) {
			dass.acceptedemandeById(DemandeAvanceSalaireId);
		}
	 
	@PostMapping("/addDemandeAvanceSalaire")
	@ResponseBody
	public Object addDemandeAvanceSalaire (@RequestBody DemandeAvanceSalaireDto datDto){
		DemandeAvanceSalaire dat = modelMapper.map(datDto, DemandeAvanceSalaire.class);
     dat = dass.addDemandeAvanceSalaire(dat);
     datDto = modelMapper.map(dat, DemandeAvanceSalaireDto.class);
     return ResponseEntity.status(HttpStatus.CREATED).body(datDto);
 }
		
	
	
	
	
	
	@GetMapping("/retrieveDemandeAvanceSalaire/{DemandeAvanceSalaireId}")
	@ResponseBody
	public Object DemandeAvanceSalaire(@PathVariable Long DemandeAvanceSalaireId ) {
		DemandeAvanceSalaire das = dass.getDemandeAvanceSalaireById(DemandeAvanceSalaireId) ;
		DemandeAvanceSalaireDto datDto= modelMapper.map(das, DemandeAvanceSalaireDto.class);
 return ResponseEntity.status(HttpStatus.OK).body(datDto);
	}
	
	
	
	@PutMapping("/updateDemandeAvanceSalaire/{DemandeAvanceSalaireId}")
	@ResponseBody
	 public Object UpdateDemandeAvanceSalaire (@Validated @RequestBody DemandeAvanceSalaireDto DemandeAvanceSalaireDto , @PathVariable Long DemandeAvanceSalaireId) {
				DemandeAvanceSalaire DemandeAvanceSalaire = modelMapper.map(DemandeAvanceSalaireDto,DemandeAvanceSalaire.class);
				DemandeAvanceSalaire= dass.updateDemandeAvanceSalaire( DemandeAvanceSalaireId, DemandeAvanceSalaire);
		      DemandeAvanceSalaireDto = modelMapper.map(DemandeAvanceSalaire,DemandeAvanceSalaireDto.class);
		       return ResponseEntity.status(HttpStatus.CREATED).body(DemandeAvanceSalaireDto);
		       }
	

	
	
	@DeleteMapping("/deleteDemandeAvanceSalaire/{DemandeAvanceSalaireId}")
	@ResponseBody
	public void deleteDemandeAvanceSalaire(@PathVariable ("DemandeAvanceSalaireId") Long DemandeAvanceSalaireId){
		dass.deleteDemandeAvanceSalaireById(DemandeAvanceSalaireId);
	}

}
