package smartup.microservices.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name="file")
@Data @NoArgsConstructor @AllArgsConstructor
public class UploadFile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="file_id")
	private Long id;
	@Column(name="file_nom")
	private String name;
	@Column(name="file_type")
	private String type;
	@Lob@Column(name="file_image")
	private byte[] image;

	
	@ManyToOne
	private DemandeAttesTravail demandeAttesTravail;
}
