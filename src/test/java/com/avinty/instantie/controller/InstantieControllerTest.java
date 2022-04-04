package com.avinty.instantie.controller;

import java.util.ArrayList;
import java.util.List;

import com.avinty.instantie.dto.AlgemeenDto;
import com.avinty.instantie.dto.InstantieCategorieDto;
import com.avinty.instantie.dto.InstantieDto;
import com.avinty.instantie.service.IAlgemeenService;
import com.avinty.instantie.service.IInstantieCategorieService;
import com.avinty.instantie.service.IInstantieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class InstantieControllerTest {

    @Mock
    IInstantieCategorieService instantieCategorieService;

    @Mock
    IAlgemeenService algemeenService;

    @Mock
    IInstantieService instantieService;

    @Mock
    List<InstantieCategorieDto> instantieCategories = new ArrayList<>();

    @Mock
    List<InstantieDto> instantieDtos = new ArrayList<>();

    @Mock
    AlgemeenDto algemeenDto = new AlgemeenDto();

    @Mock
    InstantieCategorieDto instantieCategorieDto = new InstantieCategorieDto();

    @Mock
    InstantieDto instantieDto = new InstantieDto();

    private InstantieController instantieController;

    @BeforeEach
    public void setup() {
        openMocks(this);
        instantieController = new InstantieController(instantieCategorieService, instantieService, algemeenService);
    }

    private void validateOK(ResponseEntity response, Object body) {

        // Assert the Operation.
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(body, response.getBody());

    }

    @Test
    void testGetAllCategories() {

        when(instantieCategorieService.getActiveInstantieCategorie(null, Boolean.FALSE))
                .thenReturn(instantieCategories);

        ResponseEntity<List<InstantieCategorieDto>>
                response = instantieController.getAll(null);

        validateOK(response, instantieCategories);

        verify(instantieCategorieService, times(1))
                .getActiveInstantieCategorie(null, false);

        verifyNoMoreInteractions(instantieCategorieService);
    }

    @Test
    void testGetAllCategoriesByName() {

        when(instantieCategorieService.getActiveInstantieCategorie("TEST", Boolean.TRUE))
                .thenReturn(instantieCategories);

        ResponseEntity<List<InstantieCategorieDto>>
                response = instantieController.getAll("TEST");

        validateOK(response, instantieCategories);

        verify(instantieCategorieService, times(1))
                .getActiveInstantieCategorie("TEST", true);

        verifyNoMoreInteractions(instantieCategorieService);
    }

    @Test
    void testGetAllInstanties() {

        when(instantieService.getActiveInstantie(1L)).thenReturn(instantieDtos);

        ResponseEntity<List<InstantieDto>>
                response = instantieController.getAllInstanties(1L);

        validateOK(response, instantieDtos);

        verify(instantieService, times(1)).getActiveInstantie(1L);

        verifyNoMoreInteractions(instantieService);
    }

    @Test
    void testSaveAlgemeen() {

        when(algemeenService.save(algemeenDto)).thenReturn(algemeenDto);

        ResponseEntity<AlgemeenDto> response = instantieController.saveAlgemeen(algemeenDto);

        validateOK(response, algemeenDto);

        verify(algemeenService, times(1)).save(algemeenDto);

        verifyNoMoreInteractions(algemeenService);
    }

    @Test
    void testSaveInstantieCategorie() {

        when(instantieCategorieService.save(instantieCategorieDto)).thenReturn(instantieCategorieDto);

        ResponseEntity<InstantieCategorieDto> response = instantieController.saveInstantieCategorie(instantieCategorieDto);

        validateOK(response, instantieCategorieDto);

        verify(instantieCategorieService, times(1)).save(instantieCategorieDto);

        verifyNoMoreInteractions(instantieCategorieService);
    }

    @Test
    void testSaveInstantie() {

        when(instantieService.save(instantieDto)).thenReturn(instantieDto);

        ResponseEntity<InstantieDto> response = instantieController.saveInstantie(instantieDto);

        validateOK(response, instantieDto);

        verify(instantieService, times(1)).save(instantieDto);

        verifyNoMoreInteractions(instantieService);
    }

    @Test
    void testDeleteInsantieCategorie() {
        ResponseEntity<String> response = instantieController.deleteCategorie(1L);
        validateOK(response, response.getBody());
        verify(instantieCategorieService, times(1)).delete(1L);
        verifyNoMoreInteractions(instantieCategorieService);
    }
}
