package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationDao extends JpaRepository<Formation, Long> {
    /**
     * c'une méthode qui permet de récuperer une formation à partir de son nom
     *
     * @param nom le nom de la formation qu'on cherche
     * @return une formation
     */
    @Query("select f from Formation f where f.nom= :nom")
    public Formation findByNom(@Param("nom") String nom);
}
