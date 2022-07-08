package smartup.microservices.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name="employer_conges_dem_type")
public class TypeConge implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name="employer_conges_dem_type_id")
    private int employerCongesDemTypeId;
    @Column(name="employer_conges_dem_dem_type")
    private String employerCongesDemDemType;
    @OneToMany(mappedBy="typeConge")
    private Set<DemandeConge> demandeConge;
}
