package com.avinty.instantie.assembler;

import com.avinty.instantie.dto.InstantieDto;
import com.avinty.instantie.entity.InstantieEntity;
import com.avinty.instantie.util.StringTrimMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StringTrimMapper.class})
public interface InstantieMapper {

    @Mapping(target = "instCategorie", ignore = true)
    InstantieDto to(InstantieEntity entity);

    @Mapping(target = "instCategorie", ignore = true)
    InstantieEntity create(InstantieDto dto);
}
