package com.ib.formationapi.service;

import com.ib.formationapi.dao.PersonneDao;
import com.ib.formationapi.entity.Personne;
import com.ib.formationapi.entity.Session;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    @Autowired
    private PersonneDao personneDao;

    public List<Personne> findAll() {
        return this.personneDao.findAll();
    }

    public Personne findById(Long id) throws NotFoundException {
        Optional<Personne> optionalPersonne = this.personneDao.findById(id);
        if (!optionalPersonne.isPresent()) {
            throw new NotFoundException("L'id " + id + " dans la table personne n'existe pas");
        }
        return optionalPersonne.get();
    }

    public Personne create(Personne personne) throws AlreadyExistException, InvalidArgumentException {
        if (personne == null) {
            throw new InvalidArgumentException("L'objet personne ne doit pas être null");
        }
        personne.setId(null);
        return this.personneDao.save(personne);
    }

    public Personne update(Personne personne, Long id) {
        if (!this.personneDao.existsById(personne.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'enregistrement personne (Id : " + id + " ) n'a pas été mise à jour");
        }
        return this.personneDao.save(personne);
    }

    public void delete(Long id) {
        if (!this.personneDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de trouver l'enregistrement (Id : " + id + " ) à supprimer ");
        }
        this.personneDao.deleteById(id);
        if (this.personneDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Erreur lors de la suppression d'un enregistrement personne");
        }
    }

}
