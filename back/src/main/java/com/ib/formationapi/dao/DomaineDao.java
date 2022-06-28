package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineDao extends JpaRepository<Domaine,Long> {
}
