package com.ib.formationapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDto {

    private int id;
    private String titre;
    private List<ThemeDto> sousThemeListe;
    private boolean estSousTheme;
    private List<FormationDto> formationsList;
}
