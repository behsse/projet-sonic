package com.ib.formationapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Classe Session représentant la table dans la base de données
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lieuSession;
    private String dateDebut;
    private String dateFin;
    private String typeSession;
    @Column(name="session_valide",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean sessionValide;

    @ManyToMany
    @JoinTable(
            name = "session_formation",
            joinColumns = @JoinColumn(name = "id_session"),
            inverseJoinColumns = @JoinColumn(name = "id_formation"))
    private List<Formation>  formationsListe;

    @ManyToMany(mappedBy = "personnesListe")
    private List<Personne> personnesListe;

    /**
     * A mettre dans la classe formation

     @ManyToMany(mappedBy = "formationsListe")
     private List<Session> sessionsListe;

     */

}