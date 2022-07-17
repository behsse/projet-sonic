package com.ib.formationapi.service;

import com.ib.formationapi.dao.SessionDao;
import com.ib.formationapi.entity.Session;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionDao sessionDao;

    public List<Session> findAll() {
        return this.sessionDao.findAll();
    }

    public Session findById(Long id) throws NotFoundException {
        Optional<Session> optionalSession = this.sessionDao.findById(id);
        if (!optionalSession.isPresent()) {
            throw new NotFoundException("L'id " + id + "de la session n'existe pas");
        }
        return optionalSession.get();
    }

    public Session create(Session session) throws AlreadyExistException, InvalidArgumentException {
        if (session == null) {
            throw new InvalidArgumentException("L'objet session ne doit pas être null");
        }
        session.setId(null);
        return this.sessionDao.save(session);
    }

    public Session update(Session session, Long id) {
        if (!this.sessionDao.existsById(session.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'enregistrement session n'a pas été mise à jour");
        }
        return this.sessionDao.save(session);
    }

    public void delete(Long id) {
        if (!this.sessionDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de trouver la session à supprimer ");
        }
        this.sessionDao.deleteById(id);
        if (this.sessionDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Erreur lors de la suppression d'une session");
        }
    }

    public List<Session> getSessionsByFormationId(final Long formationId) {

        return sessionDao.findByFormationsListe_Id(formationId);
    }
}
