package com.ib.formationapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDto {
    private int id;
    private String intitule;
    private String publicConcerne;
    private String objectif;
    private String programme;
    private int duree;
    private boolean distanciel;
    private List<String> prerequisListe;
    private ThemeDto theme;


}
