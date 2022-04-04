package com.avinty.instantie.service.impl;

import com.avinty.instantie.assembler.AlgemeenAssembler;
import com.avinty.instantie.dto.AlgemeenDto;
import com.avinty.instantie.entity.AlgemeenEntity;
import com.avinty.instantie.repository.AlgemeenRepository;
import com.avinty.instantie.service.IAlgemeenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class AlgemeenServiceImpl implements IAlgemeenService {

    private final AlgemeenRepository repository;
    private final AlgemeenAssembler assembler;

    public AlgemeenServiceImpl(AlgemeenRepository algeMeenRepository, AlgemeenAssembler assembler) {
        this.repository = algeMeenRepository;
        this.assembler = assembler;
    }

    @Override
    public AlgemeenDto save(AlgemeenDto algemeenDto) {
        log.info("start save Algemeen {}", this.getClass().getSimpleName());
        AlgemeenEntity entity = assembler.toEntity(algemeenDto, null);

        return assembler.toResource(repository.saveAndFlush(entity));
    }
}
