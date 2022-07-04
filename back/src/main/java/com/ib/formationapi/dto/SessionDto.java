package com.ib.formationapi.dto;

import com.ib.formationapi.entity.Formation;
import com.ib.formationapi.entity.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {
    private Long id;
    private String lieuSession;
    private String dateDebut;
    private String dateFin;
    private String typeSession;
    private boolean sessionValide;
    private List<FormationDto> formationsListe;
    private List<PersonneDto> personnesListe;
}
