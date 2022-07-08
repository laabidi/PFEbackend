package smartup.microservices.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name="employer_attes_travail_dem")
@Data @NoArgsConstructor @AllArgsConstructor
public class DemandeAttesTravail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employer_att_travail_dem_id")
    private int employerAttesTravailDemId;
    @Column(name="employer_att_travail_dem_date")
    private LocalDate employerAttesTravailDemDate;
    @Column(name="employer_att_travail_status")
    private String employerAttesTravailStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;
    
    @OneToMany(mappedBy="demandeAttesTravail")
    private Set <UploadFile> uploadfile;

}
