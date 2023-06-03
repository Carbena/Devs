package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.CreateProgLangRequest;
import kodlama.io.Devs.business.requests.DeleteProgLangRequest;
import kodlama.io.Devs.business.requests.UpdateProgLangRequest;
import kodlama.io.Devs.business.responses.GetAllProgLangResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageservice;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageservice) {
		super();
		this.programmingLanguageservice = programmingLanguageservice;
		
	}
	
	@PostMapping("/add")
	public void add(CreateProgLangRequest createProgLangRequest) {
		programmingLanguageservice.add(createProgLangRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllProgLangResponse> getAll(){
		return programmingLanguageservice.getAll();
	}
	
	@PostMapping("/update")
	public void update(UpdateProgLangRequest updateProgLangRequest) {
		programmingLanguageservice.update(updateProgLangRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteProgLangRequest deleteProgLangRequest) {
		programmingLanguageservice.delete(deleteProgLangRequest);
	}
	

}
