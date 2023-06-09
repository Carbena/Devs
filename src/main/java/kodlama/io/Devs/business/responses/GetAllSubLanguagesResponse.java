package kodlama.io.Devs.business.responses;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubLanguagesResponse {
	
	private int id;
	private String name;
	private ProgrammingLanguage programmingLanguage;
	

}
