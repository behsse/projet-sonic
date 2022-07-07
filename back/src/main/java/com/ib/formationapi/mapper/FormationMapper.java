package com.ib.formationapi.mapper;

import com.ib.formationapi.dto.FormationDto;
import com.ib.formationapi.entity.Formation;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

/**
 * Interface permettant a mapStruct de générer un mapper entre formation et formationDto
 */
@Mapper(componentModel="spring", uses = ThemeMapper.class)
public interface FormationMapper {
    /**
     * Permet
     * @param formationDto
     * @return Formation
     */
    Formation dtoToEntity(FormationDto formationDto);

    @Mapping(target = "theme", qualifiedByName = "sansTheme")
    FormationDto entityToDto(Formation formation);


//    @IterableMapping(qualifiedByName="mapSansTheme")
//    List<FormationDto> entityToDtoSansTheme(List<Formation> formationListe);
//
//    @Named("mapSansTheme")
//    @Mapping(target = "theme", ignore = true)
//    FormationDto entityToDtoSansTheme(Formation formation);
}
