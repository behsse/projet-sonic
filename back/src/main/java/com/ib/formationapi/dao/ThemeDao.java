package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThemeDao extends JpaRepository<Theme, Long> {
    /**
     * c'est une méthode qui permet de récuperer un theme à partir de son titre
     *
     * @param titre le titre de theme qu'on cherche
     * @return un theme
     */
    public Optional<Theme> findByTitre(String titre);

}

