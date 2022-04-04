package com.avinty.instantie.service;

import com.avinty.instantie.assembler.InstantieAssembler;
import com.avinty.instantie.dto.InstantieDto;
import com.avinty.instantie.entity.InstantieEntity;
import com.avinty.instantie.repository.InstantieRepository;
import com.avinty.instantie.service.impl.InstantieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


@ExtendWith(MockitoExtension.class)
public class InstantieServiceTest {

    @InjectMocks
    InstantieServiceImpl instantieService;

    @Mock
    InstantieAssembler instantieAssembler;

    @Mock
    InstantieRepository instantieRepository;

    @Mock
    List<InstantieEntity> instantieEntities = new ArrayList<>();

    @Mock
    List<InstantieDto> instantieDtos = new ArrayList<>();

    @Mock
    InstantieDto instantieDto = new InstantieDto();

    @Mock
    InstantieEntity instantieEntity = new InstantieEntity();

    @BeforeEach
    public void setup() {
        openMocks(this);
        instantieService = new InstantieServiceImpl(instantieRepository, instantieAssembler);
    }

    @Test
    public void testSaveInstantie() {

        when(instantieAssembler.toEntity(instantieDto,null)).thenReturn(instantieEntity);
        when(instantieRepository.saveAndFlush(instantieEntity)).thenReturn(instantieEntity);
        when(instantieAssembler.toResource(instantieEntity)).thenReturn(instantieDto);

        InstantieDto dto = instantieService.save(instantieDto);

        verify(instantieAssembler,times(1)).toEntity(instantieDto,null);
        verify(instantieRepository,times(1)).saveAndFlush(instantieEntity);
        verify(instantieAssembler,times(1)).toResource(instantieEntity);

        assertNotNull(dto);
        assertEquals(dto,instantieDto);
        assertEquals(dto.getInstNaam(),instantieDto.getInstNaam());

    }

    @Test
    public void testGetActiveInstantie() {

        when(instantieRepository.findAllByInstantieCategory(1L)).thenReturn(instantieEntities);
        when(instantieAssembler.toResources(instantieEntities)).thenReturn(instantieDtos);

        List<InstantieDto> dtos = instantieService.getActiveInstantie(1L);

        verify(instantieRepository,times(1)).findAllByInstantieCategory(1L);
        verify(instantieAssembler,times(1)).toResources(instantieEntities);

        assertNotNull(dtos);
        assertEquals(dtos,instantieDtos);
        assertEquals(dtos.size(), instantieDtos.size());

    }
}
