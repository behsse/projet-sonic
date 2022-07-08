package com.ib.formationapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 *
 */
public class  Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private String password;
    private String domaineFormateur;
    private String experienceFormateur;
    private Float derniereNoteFormateur;
    private Float moyenneNoteFormateur;
    @Column(name="role_admin",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean roleAdmin;
    @Column(name="role_formateur",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean roleFormateur;
    @Column(name="role_client",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean roleClient;
    @Column(name="role_catalogue",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean roleCatalogue;

    @ManyToMany
    @JoinTable(
            name = "personne_session",
            joinColumns = @JoinColumn(name = "id_personne"),
            inverseJoinColumns = @JoinColumn(name = "id_session"))
    private List<Session> sessionsListe = new ArrayList<>();
}
