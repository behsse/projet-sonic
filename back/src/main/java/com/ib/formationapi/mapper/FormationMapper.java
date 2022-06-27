package com.ib.formationapi.mapper;

import com.ib.formationapi.dto.FormationDto;
import com.ib.formationapi.entity.Formation;
import org.mapstruct.Mapper;
/**
 * Interface permettant a mapStruct de générer un mapper entre formation et formationDto
 */
@Mapper(componentModel="spring")
public interface FormationMapper {
    /**
     * Permet
     * @param formationDto
     * @return Formation
     */
    Formation dtoToEntity(FormationDto formationDto);
    FormationDto entityToDto(Formation formation);
}
