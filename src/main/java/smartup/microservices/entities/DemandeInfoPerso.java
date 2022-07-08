package smartup.microservices.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name="demandeinfoperso")
public class DemandeInfoPerso implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;
}

