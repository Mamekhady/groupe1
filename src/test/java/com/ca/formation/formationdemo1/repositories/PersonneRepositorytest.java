package com.ca.formation.formationdemo1.repositories;

import com.ca.formation.formationdemo1.models.Personne;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PersonneRepositorytest {

  @Autowired
  PersonneRepository personneRepository;

  @Test
  public void ajouterPersonne() {
    Personne personne = personneRepository.save(new Personne("tonux", "samb", 50));
    assertNotNull(personne);
    assertEquals(personne.getNom(), "tonux");
  }
  @Test
  public  void findAll(){
    List<Personne> personList= (List<Personne>) personneRepository.findAll();
    assertEquals("Beau",personList.get(0).getNom());
    assertEquals(personList.size(),4);

  }
  @Test
  public void update(){
    Personne personne = personneRepository.save(new Personne("tonux1", "samb1", 35));
    personne.setNom("Fall");
    assertNotNull(personne);
    assertEquals(personne.getNom(), "Fall");
  }
  @Test
  public  void delete(){
    Personne personne = new Personne("nom", "prenom", 20);
    personneRepository.save(personne);

    personneRepository.delete(personne);

    assertThat(personneRepository.findById(personne.getId()));
  }
  @Test
  public void findById(){
    //Given
    Personne pers = personneRepository.save(new Personne("badiane", "khady", 24));
    //When
    Optional<Personne> person = personneRepository.findById(pers.getId());
    //Then
    assertNotNull(person);
    assertEquals("badiane", person.get().getNom());

  }
  @Test
  public void findByNom() {
    Personne personne1 = new Personne("nom", "prenom", 30);
    Personne personne2 = new Personne("Cisse", "Mame khady", 20);
    personneRepository.save(personne1);
    personneRepository.save(personne2);
    List<Personne> personnes = new ArrayList<>();
    personnes.add(personne1);
    personnes.add(personne2);

    assertThat(personneRepository.findByNom("Cisse")).isNotNull();
    assertEquals(1, personneRepository.findByNom("Cisse").size());
  }
  @Test
  public void findByNomAndPrenom() {
    Personne personne1 = new Personne("nom1", "prenom1", 30);
    Personne personne2 = new Personne("nom1", "prenom2", 20);
    personneRepository.save(personne1);
    personneRepository.save(personne2);
    List<Personne> personnes = new ArrayList<>();
    personnes.add(personne1);
    personnes.add(personne2);

    assertThat(personneRepository.findByNomAndPrenom("nom1","prenom1")).isNotNull();
    assertEquals(1, personneRepository.findByNomAndPrenom("nom1","prenom1").size());
  }
  @Test
  public void findNomPrenom2() {
    Personne personne1 = new Personne("nom111", "prenom111", 30);
    Personne personne2 = new Personne("nom222", "prenom222", 20);
    personneRepository.save(personne1);
    personneRepository.save(personne2);
    List<Personne> personnes = new ArrayList<>();
    personnes.add(personne1);
    personnes.add(personne2);

    assertThat(personneRepository.findNomPrenom("nom111","prenom111")).isNotNull();
    assertEquals(1, personneRepository.findNomPrenom("nom222","prenom222").size());
  }
  @Test
  public void ageGreaterThan() {
    Personne personne1 = new Personne("nom1", "prenom1", 5);
    Personne personne2 = new Personne("nom2", "prenom2", 10);
    Personne personne3 = new Personne("nom3", "prenom3", 8);
    personneRepository.save(personne1);
    personneRepository.save(personne2);
    personneRepository.save(personne3);
    List<Personne> personnes = new ArrayList<>();
    personnes.add(personne1);
    personnes.add(personne2);
    personnes.add(personne3);

    Assert.assertEquals(personnes.size(), personneRepository.ageGreaterThan(10).size());
  }



  // TODO: ajouter un test sur les autres methodes comme delete, findByNom, etc...

}
