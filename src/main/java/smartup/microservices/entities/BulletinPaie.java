package smartup.microservices.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class BulletinPaie {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int ficheId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateDebut;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateFin;
    private String ficheName;
    private String ficheType;
    private String typeSalaire;
    private String salaireAnnee; 
    private String salaireMois;
    
	private byte[] attestation;
}
