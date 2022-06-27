package com.ib.formationapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domaine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    @ManyToMany
    @JoinTable(
            name = "domaine_theme",
            joinColumns = @JoinColumn(name = "id_domaine"),
            inverseJoinColumns = @JoinColumn(name = "id_theme"))
    private List<Theme> themesListe;
}
