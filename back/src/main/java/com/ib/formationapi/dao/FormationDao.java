package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormationDao extends JpaRepository<Formation, Long> {
    /**
     * c'une méthode qui permet de récuperer une formation à partir de son nom
     *
     * @param intitule l' intitule de la formation qu'on cherche
     * @return une formation
     */
    public Optional<Formation> findByIntitule(String intitule);
}
