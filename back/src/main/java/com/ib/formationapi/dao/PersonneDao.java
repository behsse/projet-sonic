package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Domaine;
import com.ib.formationapi.entity.Formation;
import com.ib.formationapi.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonneDao extends JpaRepository<Personne, Long> {

    /**
     * Méthode qui permet de récupérer les données de la table Personne par son nom
     * @param nom
     * @return
     */
    public Optional<Personne> findByNom(String nom);

}
