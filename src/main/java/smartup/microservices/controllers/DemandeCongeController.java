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

import smartup.microservices.dto.DemandeCongeDto;
import smartup.microservices.entities.DemandeConge;
import smartup.microservices.services.DemandeCongeServiceImpl;


@RestController
@CrossOrigin

@RequestMapping("/api/smartrh")
public class DemandeCongeController {

	
	@Autowired
	DemandeCongeServiceImpl dcs;
	 @Autowired
	    private ModelMapper modelMapper ;
	    @GetMapping("/demandeCongeActives")
	    public Object demandeCongelistActive() {
	        List<DemandeConge> demandeConges= dcs.getDemandeCongeListActive();
	        Type listType = new TypeToken<List<DemandeCongeDto>>() {}.getType() ;
	        List <DemandeCongeDto> demandeCongeDtos= modelMapper.map(demandeConges,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(demandeCongeDtos);
	    }

	    @GetMapping("/demandeCongeDesactives")
	    public Object demandeCongelistDesactive() {
	        List<DemandeConge> demandeConges= dcs.getDemandeCongeListDesactive();
	        Type listType = new TypeToken<List<DemandeCongeDto>>() {}.getType() ;
	        List <DemandeConge> demandeCongeDtos= modelMapper.map(demandeConges,listType);
	        return ResponseEntity.status(HttpStatus.OK).body(demandeCongeDtos);
	    }
	
	
	@PostMapping("/addDemandeConge")
	@ResponseBody
	public Object addDemandeConge (@Validated @RequestBody DemandeCongeDto dcDto){
		DemandeConge dc = modelMapper.map(dcDto, DemandeConge.class);
	     dc = dcs.addDemandeConge(dc);
	     dcDto = modelMapper.map(dc, DemandeCongeDto.class);
	     return ResponseEntity.status(HttpStatus.CREATED).body(dcDto);
		}
	
	
	
	/*@GetMapping("/retrieve-all-DemandeConges")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeConge> getDemandeConges() {
		List<DemandeConge> list = dcs.retrieveAllDemandeConges();
		return list;
		}*/
	
	
	@GetMapping("/retrieveDemandeConge/{DemandeCongeId}")
	@ResponseBody
	public  Object DemandeConge(@PathVariable Long DemandeCongeId){
		DemandeConge dc = dcs.getDemandeCongeById(DemandeCongeId) ;
		DemandeCongeDto demandecongeDto= modelMapper.map(dc, DemandeCongeDto.class);
	        return ResponseEntity.status(HttpStatus.OK).body(demandecongeDto);
	    
	}
	
	
	@PutMapping("/updateDemandeConge/{employerInfosRhDemTypeId}")
	@ResponseBody
    public Object UpdateDemandeConge (@Validated @RequestBody DemandeCongeDto demandeCongeDto , @PathVariable Long employerInfosRhDemTypeId) {
		DemandeConge demandeConge = modelMapper.map(demandeCongeDto,DemandeConge.class);
		demandeConge= dcs.updateDemandeConge(employerInfosRhDemTypeId, demandeConge);
      demandeCongeDto = modelMapper.map(demandeConge,DemandeCongeDto.class);
       return ResponseEntity.status(HttpStatus.CREATED).body(demandeCongeDto);

    }
	
	
	@DeleteMapping("/deleteDemandeConge/{DemandeCongeId}")
	@ResponseBody
	public void deleteDemandeConge(@PathVariable ("DemandeCongeId") Long DemandeCongeId){
		dcs.deleteDemandeCongeById(DemandeCongeId);
	}
	
	@PutMapping("/demandeCongesActives/{DemandeCongeId}")
    public Object ActiverDemandeConge (@Validated @RequestBody DemandeCongeDto demandeCongeDto , @PathVariable Long DemandeCongeId) {
		DemandeConge demandeConge = modelMapper.map(demandeCongeDto,DemandeConge.class);
		demandeConge= dcs.activerDemandeConge(DemandeCongeId);
        demandeCongeDto = modelMapper.map(demandeConge,DemandeCongeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeCongeDto);

    }

    @PutMapping("/demandeCongesDesactives/{DemandeCongeId}")
    public Object DesactiverDemandeConge (@Validated @RequestBody DemandeCongeDto demandeCongeDto , @PathVariable Long DemandeCongeId) {
    	DemandeConge demandeConge = modelMapper.map(demandeCongeDto,DemandeConge.class);
    	demandeConge= dcs.desactiverDemandeConge(DemandeCongeId);
        demandeCongeDto = modelMapper.map(demandeConge,DemandeCongeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeCongeDto);

    }

	@PostMapping("/acceptedemandeConge/{DemandeCongeId}")
	@ResponseBody
	public void acceptedemandeById(@PathVariable Long DemandeCongeId) {
		dcs.acceptedemandeById(DemandeCongeId);
	}
}
