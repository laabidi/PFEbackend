package smartup.microservices.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandeInfoPersoDto {
	
	private int employerInfosPersoRhDemLibelle;
	private String employerInfosPersoRhDemMatricule;
	private String employerInfosPersoRhDemUsername;
	private String employerInfosPersoRhDemAdress;
	private String employerInfosPersoRhDemCity;	
	private String employerInfosPersoRhDemCountry;	
	private int employerInfosPersoRhDemCodePostal;
	private int employerInfosPersoRhDemPhone;
	private String employerInfosPersoRhDemEmail;
	private String employerInfosPersoRhDemBanque;
	private int employerInfosPersoRhDemRib;
	private int active;
}
