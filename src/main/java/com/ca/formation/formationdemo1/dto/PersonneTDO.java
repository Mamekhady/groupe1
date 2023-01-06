package com.ca.formation.formationdemo1.dto;

public class PersonneTDO {
    private Long id;


    private String nom;


    private String prenom;


    private int age;

    public PersonneTDO() {
    }

    public PersonneTDO(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

}
