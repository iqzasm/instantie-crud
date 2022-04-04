package com.avinty.instantie.assembler;

import com.avinty.instantie.dto.AlgemeenDto;
import com.avinty.instantie.entity.AlgemeenEntity;
import com.avinty.instantie.util.StringTrimMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {StringTrimMapper.class})
public interface AlgeMeenMapper {

    AlgemeenDto to(AlgemeenEntity entity);

    AlgemeenEntity create(AlgemeenDto dto);
}
