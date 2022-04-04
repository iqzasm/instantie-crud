package com.avinty.instantie.service;

import com.avinty.instantie.assembler.AlgemeenAssembler;
import com.avinty.instantie.dto.AlgemeenDto;
import com.avinty.instantie.entity.AlgemeenEntity;
import com.avinty.instantie.repository.AlgemeenRepository;
import com.avinty.instantie.service.impl.AlgemeenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class AlgemeenServiceTest {

    @InjectMocks
    AlgemeenServiceImpl algemeenService;

    @Mock
    AlgemeenAssembler algemeenAssembler;

    @Mock
    AlgemeenRepository algemeenRepository;

    @Mock
    AlgemeenDto algemeenDto = new AlgemeenDto();

    @Mock
    AlgemeenEntity algemeenEntity = new AlgemeenEntity();

    @BeforeEach
    public void setup() {
        openMocks(this);
        algemeenService = new AlgemeenServiceImpl(algemeenRepository, algemeenAssembler);
    }

    @Test
    public void testSaveInstantie() {

        when(algemeenAssembler.toEntity(algemeenDto,null)).thenReturn(algemeenEntity);
        when(algemeenRepository.saveAndFlush(algemeenEntity)).thenReturn(algemeenEntity);
        when(algemeenAssembler.toResource(algemeenEntity)).thenReturn(algemeenDto);

        AlgemeenDto dto = algemeenService.save(algemeenDto);

        verify(algemeenAssembler,times(1)).toEntity(algemeenDto,null);
        verify(algemeenRepository,times(1)).saveAndFlush(algemeenEntity);
        verify(algemeenAssembler,times(1)).toResource(algemeenEntity);

        assertNotNull(dto);
        assertEquals(dto,algemeenDto);
        assertEquals(dto.getAlgmNaam(),algemeenDto.getAlgmNaam());

    }
}
