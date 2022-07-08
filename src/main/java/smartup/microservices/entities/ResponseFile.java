package smartup.microservices.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ResponseFile {
	private Long id;
    private String type;
    private String message;
    private boolean Status;
    

}
