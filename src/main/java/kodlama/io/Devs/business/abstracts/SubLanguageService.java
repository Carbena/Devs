package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateSubLanguageRequest;
import kodlama.io.Devs.business.requests.DeleteSubLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateSubLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllSubLanguagesResponse;

public interface SubLanguageService {
	void add(CreateSubLanguageRequest createSubRequest);
	void update(UpdateSubLanguageRequest updateSubRequest);
	void delete(DeleteSubLanguageRequest deleteSubRequest);
	List<GetAllSubLanguagesResponse> getAll();

}
