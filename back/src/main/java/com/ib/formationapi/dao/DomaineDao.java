package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Domaine;
import com.ib.formationapi.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomaineDao extends JpaRepository<Domaine, Long> {
    /**
     * c'une méthode qui permet de récuperer un domaine à partir de son nom
     *
     * @param intitule l' intitule du domaine qu'on cherche
     * @return une formation
     */
    public Optional<Domaine> findByIntitule(String intitule);
}
