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
	 @PutMapping("/DemandeFraisProfesActives/{DemandeFraisProfesId}")
	    public Object ActiverDemandeFraisProfes (@Validated @RequestBody DemandeFraisProfesDto DemandeFraisProfesDto , @PathVariable Long DemandeFraisProfesId) {
			DemandeFraisProfes DemandeFraisProfes = modelMapper.map(DemandeFraisProfesDto,DemandeFraisProfes.class);
			DemandeFraisProfes= dfps.activerDemandeFraisProfes(DemandeFraisProfesId);
	        DemandeFraisProfesDto = modelMapper.map(DemandeFraisProfes,DemandeFraisProfesDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeFraisProfesDto);

	    }

	    @PutMapping("/DemandeFraisProfesDesactives/{DemandeFraisProfesId}")
	    public Object DesactiverDemandeFraisProfes (@Validated @RequestBody DemandeFraisProfesDto DemandeFraisProfesDto , @PathVariable Long DemandeFraisProfesId) {
	    	DemandeFraisProfes DemandeFraisProfes = modelMapper.map(DemandeFraisProfesDto,DemandeFraisProfes.class);
	    	DemandeFraisProfes= dfps.desactiverDemandeFraisProfes(DemandeFraisProfesId);
	        DemandeFraisProfesDto = modelMapper.map(DemandeFraisProfes,DemandeFraisProfesDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(DemandeFraisProfesDto);

	    }

		@PostMapping("/accepteDemandeFraisProfes/{DemandeFraisProfesId}")
		@ResponseBody
		public void acceptedemandeById(@PathVariable Long DemandeFraisProfesId) {
			dfps.acceptedemandeById(DemandeFraisProfesId);
		}
	 
	@PostMapping("/addDemandeFraisProfes")
	@ResponseBody
	public Object addDemandeFraisProfes (@RequestBody DemandeFraisProfesDto datDto){
		DemandeFraisProfes dat = modelMapper.map(datDto, DemandeFraisProfes.class);
     dat = dfps.addDemandeFraisProfes(dat);
     datDto = modelMapper.map(dat, DemandeFraisProfesDto.class);
     return ResponseEntity.status(HttpStatus.CREATED).body(datDto);
 }
		
	
	
	
	@GetMapping("/retrieveAllDemandeFraisProfes")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeFraisProfes> getDemandeFraisProfess() {
		List<DemandeFraisProfes> list = dfps.retrieveAllDemandeFraisProfess();
		return list;
		}
	
	
	@GetMapping("/retrieveDemandeFraisProfes/{DemandeFraisProfesId}")
	@ResponseBody
	public Object DemandeFraisProfes(@PathVariable Long DemandeFraisProfesId) {
		DemandeFraisProfes produit = dfps.getDemandeFraisProfesById(DemandeFraisProfesId) ;
		DemandeFraisProfesDto datDto= modelMapper.map(produit, DemandeFraisProfesDto.class);
 return ResponseEntity.status(HttpStatus.OK).body(datDto);
	}
	
	
	
	@PutMapping("/updateDemandeFraisProfes/{DemandeFraisProfesId}")
	@ResponseBody
	 public Object UpdateDemandeFraisProfes (@Validated @RequestBody DemandeFraisProfesDto DemandeFraisProfesDto , @PathVariable Long DemandeFraisProfesId) {
				DemandeFraisProfes DemandeFraisProfes = modelMapper.map(DemandeFraisProfesDto,DemandeFraisProfes.class);
				DemandeFraisProfes= dfps.updateDemandeFraisProfes( DemandeFraisProfes);
		      DemandeFraisProfesDto = modelMapper.map(DemandeFraisProfes,DemandeFraisProfesDto.class);
		       return ResponseEntity.status(HttpStatus.CREATED).body(DemandeFraisProfesDto);
		       }

	
	
	@DeleteMapping("/deleteDemandeFraisProfes/{DemandeFraisProfesId}")
	@ResponseBody
	public void deleteDemandeFraisProfes(@PathVariable ("DemandeFraisProfesId") Long DemandeFraisProfesId){
		dfps.deleteDemandeFraisProfesById(DemandeFraisProfesId);
	}

}
