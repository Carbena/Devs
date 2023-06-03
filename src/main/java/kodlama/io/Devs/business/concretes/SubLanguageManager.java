package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SubLanguageService;
import kodlama.io.Devs.business.requests.CreateSubLanguageRequest;
import kodlama.io.Devs.business.requests.DeleteSubLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateSubLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllSubLanguagesResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.SubLanguageRepository;
import kodlama.io.Devs.entities.concretes.SubLanguage;

@Service
public class SubLanguageManager implements SubLanguageService{
	
	private SubLanguageRepository subLanguageRepository;
	private ProgrammingLanguageRepository progLangRepository;
	
	
	@Autowired
	public SubLanguageManager(SubLanguageRepository subLanguageRepository,
			ProgrammingLanguageRepository progLangRepository) {
		super();
		this.subLanguageRepository = subLanguageRepository;
		this.progLangRepository = progLangRepository;
	}

	@Override
	public void add(CreateSubLanguageRequest createSubRequest) {
		
		SubLanguage subLanguage = new SubLanguage();
		subLanguage.setName(createSubRequest.getName());
		subLanguage.setProgrammingLanguage(progLangRepository.getById(createSubRequest.getLanguageId()));
		
		subLanguageRepository.save(subLanguage);
		
		
	}

	@Override
	public void update(UpdateSubLanguageRequest updateSubRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DeleteSubLanguageRequest deleteSubRequest) {
		subLanguageRepository.deleteById(deleteSubRequest.getId());
		
	}

	@Override
	public List<GetAllSubLanguagesResponse> getAll() {
		
		List<SubLanguage> subLanguages = subLanguageRepository.findAll();
		List<GetAllSubLanguagesResponse> responseList = new ArrayList<GetAllSubLanguagesResponse>();
		
		for (SubLanguage subLanguage : subLanguages) {
			GetAllSubLanguagesResponse responseItem = new GetAllSubLanguagesResponse();
			responseItem.setId(subLanguage.getId());
			responseItem.setName(subLanguage.getName());
			responseItem.setProgrammingLanguage(subLanguage.getProgrammingLanguage());
			
			responseList.add(responseItem);
		}
		
		return responseList;
	}

}
