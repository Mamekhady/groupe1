package com.ca.formation.formationdemo1.DTO;

import com.ca.formation.formationdemo1.models.Role;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

public class UtilisateurDTO {
    private Long id;

    private boolean enabled = true;
    private String username;
    private String password;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> authoritie = new HashSet<>();

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(String username, String password, String name, Set<Role> authoritie) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.authoritie = authoritie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
