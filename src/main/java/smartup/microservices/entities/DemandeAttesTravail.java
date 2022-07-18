package smartup.microservices.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name="employer_attes_travail_dem")
@Data @NoArgsConstructor @AllArgsConstructor
public class DemandeAttesTravail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   
    private int employerAttesTravailDemId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date employerAttesTravailDemDate;
    
    private String employerAttesTravailStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;
    
    @OneToMany(mappedBy="demandeAttesTravail")
    private Set <UploadFile> uploadfile;

}
