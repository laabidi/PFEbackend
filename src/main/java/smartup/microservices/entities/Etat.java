package smartup.microservices.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name ="employer_conges_dem_etat")
public class Etat implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employer_etat_dem_type_id")
	private Long id;
	@Column(name="employer_etat_dem_type_libelle")
	private String libelle;
	
	@OneToOne
	private DemandeConge demandeConge;
}
