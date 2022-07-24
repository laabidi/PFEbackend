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

import smartup.microservices.dto.DemandeAttesTravailDto;
import smartup.microservices.entities.DemandeAttesTravail;
import smartup.microservices.services.DemandeAttesTravailServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("/api/smartrh")
public class DemandeAttesTravailController {
	
	@Autowired
	DemandeAttesTravailServiceImpl dats;
	 @Autowired
	    private ModelMapper modelMapper ;
	   
	 
	 @GetMapping("/DemandeAttesTravailActives")
	    public Object DemandeAttesTravaillistActive() {
	        List<DemandeAttesTravail> DemandeAttesTravails= dats.getDemandeAttesTravailListActive();
	        Type listType = new TypeToken<List<DemandeAttesTravailDto>>() {}.getType() ;
	        List <DemandeAttesTravailDto> DemandeAttesTravailDtos= modelMapper.map(DemandeAttesTravails,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeAttesTravailDtos);
	    }
	 @GetMapping("/DemandeAttesTravailDesactives")
	    public Object DemandeAttesTravaillistDesactive() {
	        List<DemandeAttesTravail> DemandeAttesTravails= dats.getDemandeAttesTravailListDesactive();
	        Type listType = new TypeToken<List<DemandeAttesTravailDto>>() {}.getType() ;
	        List <DemandeAttesTravail> DemandeAttesTravailDtos= modelMapper.map(DemandeAttesTravails,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeAttesTravailDtos);
	    }
	 @PutMapping("/DemandeAttesTravailsActives/{DemandeAttesTravailId}")
	    public Object ActiverDemandeAttesTravail (@Validated @RequestBody DemandeAttesTravailDto DemandeAttesTravailDto , @PathVariable Long idDemande) {
			DemandeAttesTravail DemandeAttesTravail = modelMapper.map(DemandeAttesTravailDto,DemandeAttesTravail.class);
			DemandeAttesTravail= dats.activerDemandeAttesTravail(idDemande);
	        DemandeAttesTravailDto = modelMapper.map(DemandeAttesTravail,DemandeAttesTravailDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeAttesTravailDto);

	    }

	    @PutMapping("/DemandeAttesTravailsDesactives/{DemandeAttesTravailId}")
	    public Object DesactiverDemandeAttesTravail (@Validated @RequestBody DemandeAttesTravailDto DemandeAttesTravailDto , @PathVariable Long idDemande) {
	    	DemandeAttesTravail DemandeAttesTravail = modelMapper.map(DemandeAttesTravailDto,DemandeAttesTravail.class);
	    	DemandeAttesTravail= dats.desactiverDemandeAttesTravail(idDemande);
	        DemandeAttesTravailDto = modelMapper.map(DemandeAttesTravail,DemandeAttesTravailDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeAttesTravailDto);

	    }

		@PostMapping("/acceptedemande/{DemandeAttesTravailId}")
		@ResponseBody
		public void acceptedemandeById(@PathVariable Long DemandeAttesTravailId) {
			dats.acceptedemandeById(DemandeAttesTravailId);
		}
	 
	@PostMapping("/add-DemandeAttesTravail")
	@ResponseBody
	public Object addDemandeAttesTravail (@RequestBody DemandeAttesTravailDto datDto){
		DemandeAttesTravail dat = modelMapper.map(datDto, DemandeAttesTravail.class);
        dat = dats.addDemandeAttesTravail(dat);
        datDto = modelMapper.map(dat, DemandeAttesTravailDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(datDto);
    }
		
	
	
	
	@GetMapping("/retrieve-all-DemandeAttesTravail")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeAttesTravail> getDemandeAttesTravails() {
		List<DemandeAttesTravail> list = dats.retrieveAllDemandeAttesTravails();
		return list;
		}
	
	
	@GetMapping("/retrieve-DemandeAttesTravail/{employerAttesTravailDemId}")
	@ResponseBody
	//public Optional<DemandeAttesTravail> retrieveDemandeAttesTravail(@PathVariable("employerAttesTravailDemId") Long DemandeAttesTravailId){
	//	return dats.retrieveDemandeAttesTravail(DemandeAttesTravailId);
	public Object retrieveDemandeAttesTravail(@PathVariable ("employerAttesTravailDemId")Long DemandeAttesTravailId ) {
		DemandeAttesTravail dat = dats.getDemandeAttesTravailById(DemandeAttesTravailId) ;
		DemandeAttesTravailDto datDto= modelMapper.map(dat, DemandeAttesTravailDto.class);
    return ResponseEntity.status(HttpStatus.OK).body(datDto);
	}
	
	
	
	@PutMapping("/update-DemandeAttesTravail/{employerAttesTravailDemId}")
	@ResponseBody
	 public Object UpdateDemandeAttesTravail (@Validated @RequestBody DemandeAttesTravailDto demandeAttesTravailDto , @PathVariable Long employerAttesTravailDemId) {
				DemandeAttesTravail demandeAttesTravail = modelMapper.map(demandeAttesTravailDto,DemandeAttesTravail.class);
				demandeAttesTravail= dats.updateDemandeAttesTravail( demandeAttesTravail);
		      demandeAttesTravailDto = modelMapper.map(demandeAttesTravail,DemandeAttesTravailDto.class);
		       return ResponseEntity.status(HttpStatus.CREATED).body(demandeAttesTravailDto);
		       }

	
	
	@DeleteMapping("/delete-DemandeAttesTravail/{DemandeAttesTravail-id}")
	@ResponseBody
	public void deleteDemandeAttesTravail(@PathVariable ("DemandeAttesTravail-id") String DemandeAttesTravailId){
		dats.deleteDemandeAttesTravailById(1);
	}

}
