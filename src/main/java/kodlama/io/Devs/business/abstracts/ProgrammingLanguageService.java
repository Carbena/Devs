package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateProgLangRequest;
import kodlama.io.Devs.business.requests.DeleteProgLangRequest;
import kodlama.io.Devs.business.requests.UpdateProgLangRequest;
import kodlama.io.Devs.business.responses.GetAllProgLangResponse;

public interface ProgrammingLanguageService {
	void add(CreateProgLangRequest createProgLangRequest);
	void update(UpdateProgLangRequest updateProgLangRequest);
	void delete(DeleteProgLangRequest deleteProgLangRequest);
	List<GetAllProgLangResponse> getAll();


}
