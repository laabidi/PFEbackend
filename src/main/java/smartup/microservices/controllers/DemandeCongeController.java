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
	
	
	@PostMapping("/add-DemandeConge")
	@ResponseBody
	public Object addDemandeConge (@Validated @RequestBody DemandeCongeDto dcDto){
		//DemandeConge DemandeConge = dcs.addDemandeConge(dc);
		//return DemandeConge;
		DemandeConge dc = modelMapper.map(dcDto, DemandeConge.class);
	     dc = dcs.addDemandeConge(dc);
	     dcDto = modelMapper.map(dc, DemandeCongeDto.class);
	     return ResponseEntity.status(HttpStatus.CREATED).body(dcDto);
		}
	
	
	// http://localhost:8081/api/smartRH/retrieve-all-DemandeConges
	@GetMapping("/retrieve-all-DemandeConges")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public List<DemandeConge> getDemandeConges() {
		List<DemandeConge> list = dcs.retrieveAllDemandeConges();
		return list;
		}
	
	// http://localhost:8081/api/smartRH/retrieve-DemandeConge/{DemandeConge-id}
	@GetMapping("/retrieve-DemandeConge/{DemandeConge-id}")
	@ResponseBody
	public  Object DemandeConge(@PathVariable int Id){
		//return dcs.retrieveDemandeConge(DemandeCongeId);
		DemandeConge dc = dcs.getDemandeCongeById(Id) ;
		DemandeCongeDto produitDto= modelMapper.map(dc, DemandeCongeDto.class);
	        return ResponseEntity.status(HttpStatus.OK).body(produitDto);
	    
	}
	

	
	//@PutMapping("/update-DemandeConge/{DemandeConge-id}")
	//@ResponseBody
	//public DemandeConge modifyDemandeConge(@RequestBody DemandeConge DemandeConge){
	//	return dcs.updateDemandeConge(DemandeConge);
	//}
	//@RequestMapping(value = "/update-DemandeConge/{DemandeConge-id}", method = RequestMethod.PUT)
	// @PutMapping("/update-DemandeConge/{DemandeConge-id}")
	// @ResponseBody
	  //  public Object updateDemandeConge (@Validated @RequestBody DemandeCongeDto dcDto , @PathVariable("DemandeConge-id") int id) {
		// DemandeConge dc = modelMapper.map(dcDto,DemandeConge.class);
	      //  dc= dcs.updateDemandeConge(id, dc);
	      //  dcDto = modelMapper.map(dc,DemandeCongeDto.class);
	      //  return ResponseEntity.status(HttpStatus.CREATED).body(dcDto);

	   // }
	@PutMapping("/update-DemandeConge/{employerInfosRhDemTypeId}")
	@ResponseBody
    public Object UpdateDemandeConge (@Validated @RequestBody DemandeCongeDto demandeCongeDto , @PathVariable int employerInfosRhDemTypeId) {
		DemandeConge demandeConge = modelMapper.map(demandeCongeDto,DemandeConge.class);
		demandeConge= dcs.updateDemandeConge(employerInfosRhDemTypeId, demandeConge);
      demandeCongeDto = modelMapper.map(demandeConge,DemandeCongeDto.class);
       return ResponseEntity.status(HttpStatus.CREATED).body(demandeCongeDto);

    }
	
	
	@DeleteMapping("/delete-DemandeConge/{DemandeCongeId}")
	@ResponseBody
	public void deleteDemandeConge(@PathVariable ("DemandeCongeId") int DemandeCongeId){
		dcs.deleteDemandeCongeById(DemandeCongeId);
	}
	
	@PutMapping("/demandeCongesActives/{DemandeCongeId}")
    public Object ActiverDemandeConge (@Validated @RequestBody DemandeCongeDto demandeCongeDto , @PathVariable int idDemande) {
		DemandeConge demandeConge = modelMapper.map(demandeCongeDto,DemandeConge.class);
		demandeConge= dcs.activerDemandeConge(idDemande);
        demandeCongeDto = modelMapper.map(demandeConge,DemandeCongeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeCongeDto);

    }

    @PutMapping("/demandeCongesDesactives/{DemandeCongeId}")
    public Object DesactiverDemandeConge (@Validated @RequestBody DemandeCongeDto demandeCongeDto , @PathVariable int idDemande) {
    	DemandeConge demandeConge = modelMapper.map(demandeCongeDto,DemandeConge.class);
    	demandeConge= dcs.desactiverDemandeConge(idDemande);
        demandeCongeDto = modelMapper.map(demandeConge,DemandeCongeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeCongeDto);

    }

	@PostMapping("/acceptedemande/{DemandeCongeId}")
	@ResponseBody
	public void acceptedemandeById(@PathVariable int DemandeCongeId) {
		dcs.acceptedemandeById(DemandeCongeId);
	}
}
