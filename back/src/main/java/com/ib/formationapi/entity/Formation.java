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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    @Column(name = "public")
    private String publicConcerne;
    private String objectif;
    private String programme;
    private int duree;
    private boolean distanciel;
    @ManyToOne
    @JoinColumn(name="id_theme")
    private Theme theme;
}
