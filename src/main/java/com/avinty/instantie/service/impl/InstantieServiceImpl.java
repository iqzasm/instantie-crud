package com.avinty.instantie.service.impl;

import java.util.List;

import com.avinty.instantie.assembler.InstantieAssembler;
import com.avinty.instantie.dto.InstantieDto;
import com.avinty.instantie.entity.InstantieEntity;
import com.avinty.instantie.repository.InstantieRepository;
import com.avinty.instantie.service.IInstantieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class InstantieServiceImpl implements IInstantieService {

    private final InstantieRepository repository;
    private final InstantieAssembler assembler;

    public InstantieServiceImpl(InstantieRepository repository,
                                InstantieAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public List<InstantieDto> getActiveInstantie(Long instCategorie) {
        log.info("start getActiveInstantie {}", this.getClass().getSimpleName());
        return assembler.toResources(repository.findAllByInstantieCategory(instCategorie));
    }

    @Override
    public InstantieDto save(InstantieDto instantieDto) {
        log.info("start save Instantie {}", this.getClass().getSimpleName());
        InstantieEntity entity = assembler.toEntity(instantieDto, null);
        return assembler.toResource(repository.saveAndFlush(entity));
    }
}
