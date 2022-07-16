package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionDao extends JpaRepository<Session, Long> {
    List<Session> findByFormationsListe_Id(final Long id);


}
