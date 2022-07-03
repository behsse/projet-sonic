package com.ib.formationapi.mapper;

import com.ib.formationapi.dto.DomaineDto;
import com.ib.formationapi.dto.ThemeDto;
import com.ib.formationapi.entity.Domaine;
import com.ib.formationapi.entity.Theme;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = ThemeMapper.class)
public interface DomaineMapper {

    Domaine dtoToEntity(DomaineDto domaineDto);

    @Mapping(target = "themesListe", qualifiedByName = "sansThemesListe")
    DomaineDto entityToDto(Domaine domaine);

//    @IterableMapping(qualifiedByName="mapSansTheme")
//    List<DomaineDto> entityToDtoSansTheme(List<Domaine> domaineListe);
//
//    @Named("mapSansTheme")
//    @Mapping(target = "themesListe", expression = "java(new ArrayList<ThemeDto>())")
//    DomaineDto entityToDtoSansTheme(Domaine domaine);
//
//
//    @Named("themeSansDomaine")
//    default List<ThemeDto> mapThemeListeSansDomaine(List<Theme> themesListe) {
//        if(themesListe == null) {
//            return new ArrayList<>();
//        }
//        ThemeMapper themeMapper = Mappers.getMapper(ThemeMapper.class);
//        return themeMapper.entityToDtoSansDomaine(themesListe);
//    }
}
