package com.avinty.instantie.assembler;

import com.avinty.instantie.dto.InstantieCategorieDto;
import com.avinty.instantie.entity.InstantieCategorieEntity;
import com.avinty.instantie.util.StringTrimMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StringTrimMapper.class})
public interface InstantieCategorieMapper {

    @Mapping(target = "incaType", ignore = true)
    InstantieCategorieDto to(InstantieCategorieEntity entity);

    @Mapping(target = "incaType", ignore = true)
    @Mapping(target = "incaAangeMaaktDatum", ignore = true)
    InstantieCategorieEntity create(InstantieCategorieDto dto);
}
