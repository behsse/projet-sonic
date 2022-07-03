package com.ib.formationapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domaine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    @ManyToMany
    @JoinTable(
            name = "domaine_theme",
            joinColumns = @JoinColumn(name = "id_domaine"),
            inverseJoinColumns = @JoinColumn(name = "id_theme"))
//    @JsonBackReference
    private List<Theme> themesListe;
}
