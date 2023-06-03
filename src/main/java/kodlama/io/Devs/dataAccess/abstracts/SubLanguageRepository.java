package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.SubLanguage;

public interface SubLanguageRepository extends JpaRepository<SubLanguage,Integer>{

}
