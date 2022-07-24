package smartup.microservices.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class DemandeFraisProfes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employer_frais_dem_id")
    private int employerFraisDemId;
    @Column(name="employer_frais_dem_montant")
    private float employerFraisDemMontant;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="employer_frais_dem_date_mission")
    private Date employerFraisDemDateMission;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="employer_frais_dem_date")
    private Date employerFraisDemDate;
    @Column(name="employer_frais_dem_status")
    private String employerFraisDemStatus;
   private String active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;

}
