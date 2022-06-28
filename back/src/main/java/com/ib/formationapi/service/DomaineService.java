package com.ib.formationapi.service;

import com.ib.formationapi.dao.DomaineDao;
import com.ib.formationapi.entity.Domaine;
import com.ib.formationapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * classe de service de l'entité domaine
 *
 * @author ANGHARI
 */
@Service
public class DomaineService {
    @Autowired
    private DomaineDao domaineDao;
    /**
     * c'est une méthode qui permet de récuperer la liste des domaines
     *
     * @return la liste de domaine
     */
    public List<Domaine> findAll(){
        return this.domaineDao.findAll();
    }

    public Domaine findById(Long id) throws NotFoundException {
        Optional<Domaine> optionalDomaine=this.domaineDao.findById(id);
        if(!optionalDomaine.isPresent()){
           throw new NotFoundException("le domaine avec l'id "+id+"n'existe pas");
        }
        return optionalDomaine.get();
    }

    /**
     * c'est une méthode qui permet de créer une formation
     *
     * @param domaine q'on va créer
     * @return une formation
     */
//    public Domaine create(Domaine domaine) throws FormationAlreadyExistException, InvalidArgumentException {
//        if(domaine == null) {
//            throw new InvalidArgumentException("la formation ne doit pas être null");
//        }
//        domaine.setId(null);
//        if(domaineDao.findByIntitule(domaine.getIntitule()).isPresent()) {
//            throw new FormationAlreadyExistException("La formation avec l'intitulé " + formation.getIntitule() + " existe déja");
//        }
//        return this.domaineDao.save(formation);
//    }

    /**
     * c'est la méthode qui permet de mettre à jour une formation
     *
     * @param formation qu'on veut mettre à jour
     * @param id        de formation qu'on veut mettre à jour
     * @return une formation
     */
//    public Formation update(Formation formation, Long id) {
//        if (!this.formationDao.existsById(formation.getId())) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la formation n'a pas été mise à jour");
//        }
//        return this.formationDao.save(formation);
//    }

    /**
     * c'est une méthode qui permet de suppremer une formation
     *
     * @param id de formation qu'on veut supprimer
     */
//    public void delete(Long id) {
//        if (!this.formationDao.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver la fomrmation à supprimer ");
//        }
//        this.formationDao.deleteById(id);
//        if (this.formationDao.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "erreur de la suppression de la formation");
//        }
//    }

}
