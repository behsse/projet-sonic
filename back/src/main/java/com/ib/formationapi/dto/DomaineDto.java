package com.ib.formationapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomaineDto {
    private int id;
    private String intitule;
    private List<ThemeDto> themesListe;
}
