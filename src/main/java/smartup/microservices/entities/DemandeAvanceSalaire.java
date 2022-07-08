package smartup.microservices.entities;

import java.io.Serializable;
import java.time.LocalDate;

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


@Entity(name="employer_avance_salaire_dem")
@Data @NoArgsConstructor @AllArgsConstructor
public class DemandeAvanceSalaire implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
 
    private int employerAvSalaireDemId;
   
    private float employerAvSalaireDemMontant;
   
    private LocalDate employerAvSalaireDemDate;
   
    private String employerAvSalaireStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;
    

}

