package com.ib.formationapi.mapper;

import com.ib.formationapi.dto.ThemeDto;
import com.ib.formationapi.entity.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeMapper {

    Theme dtoToEntity(ThemeDto themeDto);

    @Mapping(target="themeParent", ignore = true)
    //@Mapping( target = "formationsList", qualifiedByName = "formationSansTheme")
    //@Mapping( target = "domaineListe", qualifiedByName = "domaineSansTheme")
    ThemeDto entityToDto(Theme theme);
    @Named( "sansTheme" )
    @Mapping(target="themeParent", ignore = true)
    @Mapping(target="sousThemeListe", expression = "java(new ArrayList<ThemeDto>())")
    ThemeDto entityToDtoSansSousThemes(Theme theme);


    @Named( "sansThemesListe" )
    default List<ThemeDto> entityToDtoListSansThemes(List<Theme> themesListe) {
        if ( themesListe == null ) {
            return null;
        }

        List<ThemeDto> list = new ArrayList<ThemeDto>( themesListe.size() );
        for ( Theme theme : themesListe ) {
            list.add( entityToDtoSansSousThemes( theme ) );
        }

        return list;
    }

//    @IterableMapping(qualifiedByName="mapSansDomaine")
//    List<ThemeDto> entityToDtoSansDomaine(List<Theme> themeListe);

//    @Named("formationSansTheme")
//    default List<FormationDto> mapFormationListeSansTheme(List<Formation> formationsListe) {
//        if(formationsListe == null) {
//            return new ArrayList<>();
//        }
//        FormationMapper formationMapper = Mappers.getMapper(FormationMapper.class);
//        return formationMapper.entityToDtoSansTheme(formationsListe);
//    }

//    @Named("domaineSansTheme")
//    default List<DomaineDto> mapDomaineListeSansTheme(List<Domaine> domaineListe) {
//        if(domaineListe == null) {
//            return new ArrayList<>();
//        }
//        DomaineMapper domaineMapper = Mappers.getMapper(DomaineMapper.class);
//        return domaineMapper.entityToDtoSansTheme(domaineListe);
//    }


//
//    @Named("mapSansDomaine")
//    @Mapping(target = "domaineListe", expression = "java(new ArrayList<DomaineDto>())")
//    ThemeDto entityToDtoSansTheme(Theme theme);

}
