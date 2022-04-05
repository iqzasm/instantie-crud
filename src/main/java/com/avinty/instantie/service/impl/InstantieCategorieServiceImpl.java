package com.avinty.instantie.service.impl;

import java.util.List;

import com.avinty.instantie.assembler.InstantieCategorieAssembler;
import com.avinty.instantie.dto.InstantieCategorieDto;
import com.avinty.instantie.entity.InstantieCategorieEntity;
import com.avinty.instantie.exception.InstantieException;
import com.avinty.instantie.repository.InstantieCategorieRepository;
import com.avinty.instantie.service.IInstantieCategorieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class InstantieCategorieServiceImpl implements IInstantieCategorieService {

    private final InstantieCategorieRepository categorieRepository;
    private final InstantieCategorieAssembler assembler;

    public InstantieCategorieServiceImpl(InstantieCategorieRepository categorieRepository,
                                         InstantieCategorieAssembler assembler) {
        this.categorieRepository = categorieRepository;
        this.assembler = assembler;
    }

    @Override
    public List<InstantieCategorieDto> getActiveInstantieCategorie(String incaNaam, Boolean isFilterByName) {
        log.info("start getActiveInstantieCategorie {}", this.getClass().getSimpleName());
        if (incaNaam != null && isFilterByName.equals(Boolean.TRUE)) {
            return assembler.toResources(categorieRepository.findCategoryByName(incaNaam));
        }
        List<InstantieCategorieEntity> categorieEntities = categorieRepository.findActiveCategories();
        return assembler.toResources(categorieEntities);
    }

    @Override
    public InstantieCategorieDto save(InstantieCategorieDto categorieDto) {
        log.info("start save InstantieCategorie {}", this.getClass().getSimpleName());
        InstantieCategorieEntity entity = categorieRepository.saveAndFlush(assembler.toEntity(categorieDto, null));
        return assembler.toResource(entity);
    }

    @Override
    public void delete(Long id) {
        log.info("start delete InstantieCategorie {}", this.getClass().getSimpleName());
        categorieRepository.deleteById(id);
    }
}
