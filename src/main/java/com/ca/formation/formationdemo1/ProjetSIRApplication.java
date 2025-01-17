package com.ca.formation.formationdemo1;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.repositories.PersonneRepository;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.List;

@SpringBootApplication
public class ProjetSIRApplication {


  @Value("${mon.application.travail}")
  String monApplication;

  @Value("${mon.application.lieu}")
  String lieuFormation;

  @Autowired
  private Environment env;

  public static void main(String[] args) {
    SpringApplication.run(ProjetSIRApplication.class, args);
  }

  @Bean
  public void addBean() {
   Logger.getLogger(monApplication);
    Logger.getLogger(" Démarrage application Spring Boot");
  }

  @Bean
  public CommandLineRunner demo(PersonneRepository repository) {
    return args -> {
      Personne personne1 = repository.save(new Personne("Lacroix", "Jean", 20));
      repository.save(new Personne("Beau", "Michel", 30));
      repository.save(new Personne("Abdel", "Moussa", 40));

      repository.delete(personne1);

      List<Personne> personneList = repository.findByNomAndPrenom("Abdel", "Moussa");

      for (Personne p:personneList
      ) {
        Logger.getLogger(p.getNom()+" "+p.getPrenom());
      }

    };
  }

  @Bean
  public ClassLoaderTemplateResolver templateResolver() {
    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("templates-new/");
    templateResolver.setSuffix(".html");
    templateResolver.setCheckExistence(true);

    return templateResolver;
  }

}
