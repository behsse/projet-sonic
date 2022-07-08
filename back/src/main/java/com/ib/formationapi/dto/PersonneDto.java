package com.ib.formationapi.dto;

import com.ib.formationapi.entity.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDto {

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
    private boolean roleAdmin;
    private boolean roleFormateur;
    private boolean roleClient;
    private boolean roleCatalogue;
    private List<SessionDto> sessionsListe;
}
