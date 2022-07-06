package com.ib.formationapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @OneToMany(mappedBy = "themeParent", cascade = CascadeType.ALL)
    private List<Theme> sousThemeListe;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Theme themeParent;
    @Column(name = "est_sous_theme", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean estSousTheme;
//    @OneToMany(mappedBy = "theme")
//    @JsonManagedReference
//    private List<Formation> formationsList;
//    @ManyToMany(mappedBy = "themesListe")
//    @JsonManagedReference
//    private List<Domaine> domaineListe;
}
