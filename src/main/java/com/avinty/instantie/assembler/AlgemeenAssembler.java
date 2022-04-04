package com.avinty.instantie.assembler;

import com.avinty.instantie.dto.AlgemeenDto;
import com.avinty.instantie.entity.AlgemeenEntity;
import org.springframework.stereotype.Component;

@Component
public class AlgemeenAssembler extends AbstractResourceAssembeler<AlgemeenEntity, AlgemeenDto> {

    private final AlgeMeenMapper mapper;

    public AlgemeenAssembler(AlgeMeenMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AlgemeenDto toResource(AlgemeenEntity entity) {

        if (entity == null) {
            throw new IllegalArgumentException("entity must be provided");
        }

        return mapper.to(entity);
    }

    @Override
    public AlgemeenEntity toEntity(AlgemeenDto dto, AlgemeenEntity entity) {

        if (entity == null) {
            entity = mapper.create(dto);
        }

        return entity;
    }
}
