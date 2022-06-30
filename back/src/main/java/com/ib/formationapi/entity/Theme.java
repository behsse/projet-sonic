package com.ib.formationapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

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
    @JsonBackReference
    private Theme themeParent;
    @Column(name = "est_sous_theme", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean estSousTheme;
    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<Formation> formationsList;
    @ManyToMany(mappedBy = "themesListe")
    private List<Domaine> domaineListe;
}
