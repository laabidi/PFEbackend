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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
@Entity(name="employer_conges_dem")
public class DemandeConge implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employer_infos_rh_dem_type_id")
    private int employerInfosRhDemTypeId;
	@Temporal(TemporalType.DATE)
    @Column(name="employer_conges_dem_date_deb")
    private Date employerCongesDemDateDeb;
	@Temporal(TemporalType.DATE)
    @Column(name="employer_conges_dem_date_fin")
    private Date employerCongesDemDateFin;
    @Column(name="employer_conges_dem_nbr_jrs")
    private int employerCongesDemNbrJrs;
    @Column(name="employer_conges_dem_motif")
    private String employerCongesDemMotif;
    @Column(name="employer_id_remplacant")
    private int employerIdRemplacant;
    
    @Column(name="employer_conges_dem_taches_dele")
    private String employerCongesDemTachesDele;
    
    @Column(name="employer_conges_dem_statut")
    private String employerCongesDemStatut;
    
    
	@Temporal(TemporalType.DATE)
	@Column(name="employer_conges_dem_date")
    private Date employerCongesDemDate;
	
    @ManyToOne
    @JoinColumn(name="employer_conges_dem_type_id")
    private TypeConge typeConge;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;
    @OneToOne
    private Etat etat;
}