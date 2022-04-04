package com.avinty.instantie.assembler;

import java.util.Optional;

import com.avinty.instantie.dto.InstantieCategorieDto;
import com.avinty.instantie.entity.AlgemeenEntity;
import com.avinty.instantie.entity.InstantieCategorieEntity;
import com.avinty.instantie.repository.AlgemeenRepository;
import org.springframework.stereotype.Component;

@Component
public class InstantieCategorieAssembler extends AbstractResourceAssembeler<InstantieCategorieEntity, InstantieCategorieDto> {

    private final InstantieCategorieMapper mapper;
    private final AlgemeenRepository algeMeenRepository;

    public InstantieCategorieAssembler(InstantieCategorieMapper mapper, AlgemeenRepository algeMeenRepository) {
        this.mapper = mapper;
        this.algeMeenRepository = algeMeenRepository;
    }

    @Override
    public InstantieCategorieDto toResource(InstantieCategorieEntity entity) {

        if (entity == null) {
            throw new IllegalArgumentException("entity must be provided");
        }

        InstantieCategorieDto categorieDto = mapper.to(entity);

        if (entity.getIncaType() != null) {
            categorieDto.setIncaType(entity.getIncaType().getAlgmNummer());
        }

        return categorieDto;
    }

    @Override
    public InstantieCategorieEntity toEntity(InstantieCategorieDto dto, InstantieCategorieEntity entity) {

        if (entity == null) {
            entity = mapper.create(dto);
        }

        Optional<AlgemeenEntity> algemeenEntity = algeMeenRepository.findById(dto.getIncaType());
        if (algemeenEntity.isPresent()) {
            entity.setIncaType(algemeenEntity.get());
        }

        return entity;
    }
}
