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
public class DemandeCongeDto {
	
    private Long employerInfosRhDemTypeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date employerCongesDemDateDeb;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date employerCongesDemDateFin;
    private int employerCongesDemNbrJrs;
    private String employerCongesDemMotif;
    private int employerIdRemplacant;
    private String employerCongesDemTachesDele;
    private String employerCongesDemStatut;
    private int active ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date employerCongesDemDate;
}
