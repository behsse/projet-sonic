package com.ib.formationapi.service;

import com.ib.formationapi.dao.FormationDao;
import com.ib.formationapi.entity.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * classe de service de l'entité formation
 *
 * @author ANGHARI
 */
@Service
public class FormationService {
    @Autowired
    private FormationDao formationDao;

    /**
     * c'est une méthode qui permet de récuperer la liste des formations
     *
     * @return la liste de formation
     */
    public List<Formation> findAll() {
        return this.formationDao.findAll();
    }

    /**
     * c'est une méthode qui permet de récuperer une formation à partir de son id
     *
     * @param id l'id de formation qu'on cherche
     * @return une formation
     */
    public Formation findById(Long id) {
        Optional<Formation> optionalFormation = this.formationDao.findById(id);
        if (optionalFormation.isPresent()) {
            return optionalFormation.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * c'est une méthode qui permet de récuperer une formation à partir de son nom
     *
     * @param nom le nom de la formation
     * @return une formation
     */
    public Formation findByNom(String nom) {
        return this.formationDao.findByNom(nom);
    }

    /**
     * c'est une méthode qui permet de créer une formation
     *
     * @param formation q'on va créer
     * @return une formation
     */
    public Formation create(Formation formation) {
        return this.formationDao.save(formation);
    }

    /**
     * c'est la méthode qui permet de mettre à jour une formation
     *
     * @param formation qu'on veut mettre à jour
     * @param id        de formation qu'on veut mettre à jour
     * @return une formation
     */
    public Formation update(Formation formation, Long id) {
        if (!this.formationDao.existsById(formation.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la formation n'a pas été mise à jour");
        }
        return this.formationDao.save(formation);
    }

    /**
     * c'est une méthode qui permet de suppremer une formation
     *
     * @param id de formation qu'on veut supprimer
     */
    public void delete(Long id) {
        if (!this.formationDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver la fomrmation à supprimer ");
        }
        this.formationDao.deleteById(id);
        if (this.formationDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "erreur de la suppression de la formation");
        }
    }
}
