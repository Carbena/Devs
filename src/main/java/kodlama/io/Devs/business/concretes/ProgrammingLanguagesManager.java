package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.CreateProgLangRequest;
import kodlama.io.Devs.business.requests.DeleteProgLangRequest;
import kodlama.io.Devs.business.requests.UpdateProgLangRequest;
import kodlama.io.Devs.business.responses.GetAllProgLangResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguagesManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguagesManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgLangRequest createProgLangRequest) {
		
		ProgrammingLanguage language = new ProgrammingLanguage();
		language.setName(createProgLangRequest.getName());
		
		programmingLanguageRepository.save(language);
	}

	@Override
	public void update(UpdateProgLangRequest updateProgLangRequest) {
		ProgrammingLanguage updateItem = programmingLanguageRepository.getById(updateProgLangRequest.getId());
		updateItem.setName(updateProgLangRequest.getName());
		
		programmingLanguageRepository.save(updateItem);
		
		
	}

	@Override
	public void delete(DeleteProgLangRequest deleteProgLangRequest) {
		programmingLanguageRepository.deleteById(deleteProgLangRequest.getId());
		
	}

	@Override
	public List<GetAllProgLangResponse> getAll() {
		List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
		List<GetAllProgLangResponse> responses = new ArrayList<GetAllProgLangResponse>();
		
		for (ProgrammingLanguage progLang : languages) {
			GetAllProgLangResponse responseItem = new GetAllProgLangResponse();
			responseItem.setId(progLang.getId());
			responseItem.setName(progLang.getName());
			
			responses.add(responseItem);
			
		}
		
		return responses;
	}


}
