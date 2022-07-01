package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomaineDao extends JpaRepository<Domaine, Long> {
    /**
     * c'est une méthode qui permet de récuperer un domaine à partir de son nom
     *
     * @param intitule l' intitule du domaine qu'on cherche
     * @return un domaine
     */
    public Optional<Domaine> findByIntitule(String intitule);
}
