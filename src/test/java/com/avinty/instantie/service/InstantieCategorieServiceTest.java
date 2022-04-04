package com.avinty.instantie.service;

import java.util.ArrayList;
import java.util.List;

import com.avinty.instantie.assembler.InstantieCategorieAssembler;
import com.avinty.instantie.dto.InstantieCategorieDto;
import com.avinty.instantie.entity.InstantieCategorieEntity;
import com.avinty.instantie.repository.InstantieCategorieRepository;
import com.avinty.instantie.service.impl.InstantieCategorieServiceImpl;
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
class InstantieCategorieServiceTest {

    @InjectMocks
    InstantieCategorieServiceImpl instantieCategorieService;

    @Mock
    InstantieCategorieAssembler assembler;

    @Mock
    InstantieCategorieRepository categorieRepository;

    @Mock
    List<InstantieCategorieEntity> entities = new ArrayList<>();

    @Mock
    List<InstantieCategorieDto> categorieDtos = new ArrayList<>();

    @Mock
    InstantieCategorieDto instantieCategorieDto = new InstantieCategorieDto();

    @Mock
    InstantieCategorieEntity entity = new InstantieCategorieEntity();

    @BeforeEach
    public void setup() {
        openMocks(this);
        instantieCategorieService = new InstantieCategorieServiceImpl(categorieRepository, assembler);
    }

    @Test
    void testGetActiveCategorie() {
        when(categorieRepository.findActiveCategories()).thenReturn(entities);
        when(assembler.toResources(entities)).thenReturn(categorieDtos);

        List<InstantieCategorieDto> dtoList = instantieCategorieService.getActiveInstantieCategorie(null, false);

        verify(categorieRepository, times(1)).findActiveCategories();
        verify(assembler, times(1)).toResources(entities);

        assertNotNull(dtoList);
        assertEquals(dtoList, categorieDtos);
        assertEquals(dtoList.size(), categorieDtos.size());
    }

    @Test
    void testGetActiveCategorieByName() {
        when(categorieRepository.findCategoryByName("TEST")).thenReturn(entities);
        when(assembler.toResources(entities)).thenReturn(categorieDtos);

        List<InstantieCategorieDto> dtoList = instantieCategorieService.getActiveInstantieCategorie("TEST", true);

        verify(categorieRepository, times(1)).findCategoryByName("TEST");
        verify(assembler, times(1)).toResources(entities);

        assertNotNull(dtoList);
        assertEquals(dtoList, categorieDtos);
        assertEquals(dtoList.size(), categorieDtos.size());
    }

    @Test
    void testSaveInstantieCategorie() {

        when(assembler.toEntity(instantieCategorieDto, null)).thenReturn(entity);
        when(categorieRepository.saveAndFlush(entity)).thenReturn(entity);
        when(assembler.toResource(entity)).thenReturn(instantieCategorieDto);


        InstantieCategorieDto dto = instantieCategorieService.save(instantieCategorieDto);

        verify(categorieRepository, times(1)).saveAndFlush(entity);
        verify(assembler, times(1)).toResource(entity);
        verify(assembler, times(1)).toEntity(instantieCategorieDto, null);

        assertNotNull(dto);
        assertEquals(dto, instantieCategorieDto);
        assertEquals(dto.getIncaNaam(), instantieCategorieDto.getIncaNaam());
    }

    @Test
    void testDeleteInstantieCategory() {
        instantieCategorieService.delete(1L);
        verify(categorieRepository, times(1)).deleteById(1L);
    }
}
