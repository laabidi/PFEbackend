package smartup.microservices.dto;


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
public class UtilisateurDto {
    private Long id ;
    private String username ;
    private String email ;
    private int active;
    private Long telephone;
    private String adresse;

}
