package com.ib.formationapi.service;

import com.ib.formationapi.dao.DomaineDao;
import com.ib.formationapi.dto.DomaineDto;
import com.ib.formationapi.entity.Domaine;
import com.ib.formationapi.exception.AlreadyExistException;
import com.ib.formationapi.exception.InvalidArgumentException;
import com.ib.formationapi.exception.NotFoundException;
import com.ib.formationapi.mapper.DomaineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * classe de service de l'entité domaine
 *
 * @author ANGHARI
 */
@Service
public class DomaineService {
    @Autowired
    private DomaineDao domaineDao;

    @Autowired
    private DomaineMapper domaineMapper;

    /**
     * c'est une méthode qui permet de récuperer la liste des domaines
     *
     * @return la liste de domaine
     */
    public List<DomaineDto> findAll() {
        final List<Domaine> domaineliste = domaineDao.findAll();
        return domaineliste.stream().map(domaine -> domaineMapper.entityToDto(domaine)).collect(Collectors.toList());

    }

    public DomaineDto findById(Long id) throws NotFoundException {
        Optional<Domaine> optionalDomaine = this.domaineDao.findById(id);
        if (!optionalDomaine.isPresent()) {
            throw new NotFoundException("le domaine avec l'id " + id + "n'existe pas");
        }
        return domaineMapper.entityToDto(optionalDomaine.get());
    }

    /**
     * c'est une méthode qui permet de récuperer un domaine à partir de son nom
     *
     * @param intitule l'intitule du domaine
     * @return un domaine
     */
    public DomaineDto findByIntitule(String intitule) throws NotFoundException {
        final Optional<Domaine> optionalDomaine = domaineDao.findByIntitule(intitule);
        if (!optionalDomaine.isPresent()) {
            throw new NotFoundException("le domaine avec l'intitule " + intitule + " n'existe pas");
        }
        return domaineMapper.entityToDto(optionalDomaine.get());
    }


    /**
     * c'est une méthode qui permet de créer un domaine
     *
     * @param domaine q'on va créer
     * @return un domaine
     */
    public DomaineDto create(Domaine domaine) throws AlreadyExistException, InvalidArgumentException {
        if (domaine == null) {
            throw new InvalidArgumentException("le domaine ne doit pas être null");
        }
        domaine.setId(null);
        if (domaineDao.findByIntitule(domaine.getIntitule()).isPresent()) {
            throw new AlreadyExistException("Le domaine avec l'intitulé " + domaine.getIntitule() + " existe déja");
        }
        return domaineMapper.entityToDto(domaineDao.save(domaine));
    }

    /**
     * c'est la méthode qui permet de mettre à jour un domaine
     *
     * @param domaine qu'on veut mettre à jour
     * @param id      du domaine qu'on veut mettre à jour
     * @return un domaine
     */
    public DomaineDto update(Domaine domaine, Long id) throws NotFoundException {
        if (!this.domaineDao.existsById(domaine.getId())) {
            throw new NotFoundException("le domaine " + id +" n'a pas été mise à jour car introuvable");
        }
        return domaineMapper.entityToDto(domaineDao.save(domaine));
    }

    /**
     * c'est une méthode qui permet de supprimer un domaine
     *
     * @param id du domaine qu'on veut supprimer
     */
    public void delete(Long id) {
        if (!this.domaineDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le domaine à supprimer ");
        }
        this.domaineDao.deleteById(id);
        if (this.domaineDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "erreur de la suppression du domaine");
        }
    }

}
