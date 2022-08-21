package smartup.microservices.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandeAvanceSalaireDto {
	
	private Long employerAvSalaireDemId;  
    private float employerAvSalaireDemMontant;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date employerAvSalaireDemDate;
    private String employerAvSalaireStatus;
    private int active;
}
