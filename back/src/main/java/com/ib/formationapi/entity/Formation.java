package com.ib.formationapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    @Column(name = "public")
    private String publicConcerne;
    @Column(name="description", columnDefinition = "TEXT")
    private String description;
    @Column(name="objectif", columnDefinition = "TEXT")
    private String objectif;
    private String prerequis;
    private String duree;
    @Column(name = "est_intra",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean estIntra;
    @Column(name="distanciel",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean distanciel;
    private String image;
    private String reference;

    private double tarif;

    @ManyToOne
    @JoinColumn(name = "id_theme")
//    @JsonBackReference
    private Theme theme;

    @ManyToMany(mappedBy = "formationsListe")
    @JsonIgnore
    private List<Session> sessionsListe;
}
