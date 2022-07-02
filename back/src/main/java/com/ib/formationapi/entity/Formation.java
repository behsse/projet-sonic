package com.ib.formationapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private Theme theme;
}
