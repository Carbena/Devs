package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import kodlama.io.Devs.business.abstracts.SubLanguageService;
import kodlama.io.Devs.business.requests.CreateSubLanguageRequest;
import kodlama.io.Devs.business.requests.DeleteSubLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllSubLanguagesResponse;
import kodlama.io.Devs.entities.concretes.Customer;

@RestController
@RequestMapping("/api/sublanguages")
public class SubLanguagesController {
	
	private SubLanguageService subLanguageService;

	@Autowired
	public SubLanguagesController(SubLanguageService subLanguageService) {
		super();
		this.subLanguageService = subLanguageService;
	}
	
	@PostMapping("/add")
	public void add(CreateSubLanguageRequest createSubLanguageRequest) {
		subLanguageService.add(createSubLanguageRequest);
		
	}
	
	@PostMapping("/delete")
	public void delete(DeleteSubLanguageRequest deleteSubLanguageRequest) {
		subLanguageService.delete(deleteSubLanguageRequest);
		
	}
	
	@GetMapping("/getall")
	public List<GetAllSubLanguagesResponse> getAll(){
		return subLanguageService.getAll();
	}
	
	@GetMapping("/hazelcast")
	public String deneme() {
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setClusterName("dev");
		clientConfig.getNetworkConfig().addAddress("172.18.0.2:5701");
		
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		
		IMap<String, String> mapCustomers = client.getMap("deneme"); //creates the map proxy

		mapCustomers.put("4","deneme");
		mapCustomers.put("5","deneme");
		mapCustomers.put("6","deneme");
		
		return "deneme";
	}

}
