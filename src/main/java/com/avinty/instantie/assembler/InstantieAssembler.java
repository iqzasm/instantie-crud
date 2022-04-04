package com.avinty.instantie.assembler;

import java.util.Optional;

import com.avinty.instantie.dto.InstantieDto;
import com.avinty.instantie.entity.InstantieCategorieEntity;
import com.avinty.instantie.entity.InstantieEntity;
import com.avinty.instantie.repository.InstantieCategorieRepository;
import org.springframework.stereotype.Component;

@Component
public class InstantieAssembler extends AbstractResourceAssembeler<InstantieEntity, InstantieDto> {

    private final InstantieMapper mapper;
    private final InstantieCategorieRepository categorieRepository;

    public InstantieAssembler(InstantieMapper mapper, InstantieCategorieRepository categorieRepository) {
        this.mapper = mapper;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public InstantieDto toResource(InstantieEntity entity) {

        if (entity == null) {
            throw new IllegalArgumentException("entity must be provided");
        }

        InstantieDto instantieDto = mapper.to(entity);

        if (entity.getInstCategorie() != null) {
            instantieDto.setInstCategorie(entity.getInstCategorie().getIncaNummer());
        }

        return instantieDto;
    }

    @Override
    public InstantieEntity toEntity(InstantieDto dto, InstantieEntity entity) {

        if (entity == null) {
            entity = mapper.create(dto);
        }

        Optional<InstantieCategorieEntity> categorieEntity = categorieRepository.findById(dto.getInstCategorie());

        if (categorieEntity.isPresent()) {
            entity.setInstCategorie(categorieEntity.get());
        }

        return entity;
    }
}
