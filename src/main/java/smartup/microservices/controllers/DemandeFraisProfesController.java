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

import smartup.microservices.dto.DemandeFraisProfesDto;
import smartup.microservices.entities.DemandeFraisProfes;
import smartup.microservices.services.DemandeFraisProfesServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("/api/smartrh")
public class DemandeFraisProfesController {

	@Autowired
	DemandeFraisProfesServiceImpl dfps;
	
	@Autowired
    private ModelMapper modelMapper ;
	
	 @GetMapping("/DemandeFraisProfesActives")
	    public Object DemandeFraisProfeslistActive() {
	        List<DemandeFraisProfes> DemandeFraisProfess= dfps.getDemandeFraisProfesListActive();
	        Type listType = new TypeToken<List<DemandeFraisProfesDto>>() {}.getType() ;
	        List <DemandeFraisProfesDto> DemandeFraisProfesDtos= modelMapper.map(DemandeFraisProfess,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeFraisProfesDtos);
	    }
	 @GetMapping("/DemandeFraisProfesDesactives")
	    public Object DemandeFraisProfeslistDesactive() {
	        List<DemandeFraisProfes> DemandeFraisProfess= dfps.getDemandeFraisProfesListDesactive();
	        Type listType = new TypeToken<List<DemandeFraisProfesDto>>() {}.getType() ;
	        List <DemandeFraisProfes> DemandeFraisProfesDtos= modelMapper.map(DemandeFraisProfess,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(DemandeFraisProfesDtos);
	    }
	 @PutMapping("/DemandeFraisProfessActives/{DemandeFraisProfesId}")
	    public Object ActiverDemandeFraisProfes (@Validated @RequestBody DemandeFraisProfesDto DemandeFraisProfesDto , @PathVariable Long idDemande) {
			DemandeFraisProfes DemandeFraisProfes = modelMapper.map(DemandeFraisProfesDto,DemandeFraisProfes.class);
			DemandeFraisProfes= dfps.activerDemandeFraisProfes(idDemande);
	        DemandeFraisProfesDto = modelMapper.map(DemandeFraisProfes,DemandeFraisProfesDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeFraisProfesDto);

	    }

	    @PutMapping("/DemandeFraisProfessDesactives/{DemandeFraisProfesId}")
	    public Object DesactiverDemandeFraisProfes (@Validated @RequestBody DemandeFraisProfesDto DemandeFraisProfesDto , @PathVariable Long idDemande) {
	    	DemandeFraisProfes DemandeFraisProfes = modelMapper.map(DemandeFraisProfesDto,DemandeFraisProfes.class);
	    	DemandeFraisProfes= dfps.desactiverDemandeFraisProfes(idDemande);
	        DemandeFraisProfesDto = modelMapper.map(DemandeFraisProfes,DemandeFraisProfesDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeFraisProfesDto);

	    }

		@PostMapping("/acceptedemande/{DemandeFraisProfesId}")
		@ResponseBody
		public void acceptedemandeById(@PathVariable Long DemandeFraisProfesId) {
			dfps.acceptedemandeById(DemandeFraisProfesId);
		}
	 
	@PostMapping("/add-DemandeFraisProfes")
	@ResponseBody
	public Object addDemandeFraisProfes (@RequestBody DemandeFraisProfesDto datDto){
		DemandeFraisProfes dat = modelMapper.map(datDto, DemandeFraisProfes.class);
     dat = dfps.addDemandeFraisProfes(dat);
     datDto = modelMapper.map(dat, DemandeFraisProfesDto.class);
     return ResponseEntity.status(HttpStatus.CREATED).body(datDto);
 }
		
	
	
	
	@GetMapping("/retrieve-all-DemandeFraisProfes")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeFraisProfes> getDemandeFraisProfess() {
		List<DemandeFraisProfes> list = dfps.retrieveAllDemandeFraisProfess();
		return list;
		}
	
	
	@GetMapping("/retrieve-DemandeFraisProfes/{DemandeFraisProfes-id}")
	@ResponseBody
	//public Optional<DemandeFraisProfes> retrieveDemandeFraisProfes(@PathVariable("DemandeFraisProfes-id") Long DemandeFraisProfesId){
	//	return dfps.retrieveDemandeFraisProfes(DemandeFraisProfesId);
	public Object DemandeFraisProfes(@PathVariable Long id ) {
		DemandeFraisProfes produit = dfps.getDemandeFraisProfesById(id) ;
		DemandeFraisProfesDto datDto= modelMapper.map(produit, DemandeFraisProfesDto.class);
 return ResponseEntity.status(HttpStatus.OK).body(datDto);
	}
	
	
	
	@PutMapping("/update-DemandeFraisProfes")
	@ResponseBody
	 public Object UpdateDemandeFraisProfes (@Validated @RequestBody DemandeFraisProfesDto DemandeFraisProfesDto , @PathVariable Long employerAttesTravailDemId) {
				DemandeFraisProfes DemandeFraisProfes = modelMapper.map(DemandeFraisProfesDto,DemandeFraisProfes.class);
				DemandeFraisProfes= dfps.updateDemandeFraisProfes( DemandeFraisProfes);
		      DemandeFraisProfesDto = modelMapper.map(DemandeFraisProfes,DemandeFraisProfesDto.class);
		       return ResponseEntity.status(HttpStatus.CREATED).body(DemandeFraisProfesDto);
		       }

	
	
	@DeleteMapping("/delete-DemandeFraisProfes/{DemandeFraisProfes-id}")
	@ResponseBody
	public void deleteDemandeFraisProfes(@PathVariable ("DemandeFraisProfes-id") String DemandeFraisProfesId){
		dfps.deleteDemandeFraisProfesById(1);
	}

}
