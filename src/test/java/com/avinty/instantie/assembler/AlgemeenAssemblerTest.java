package com.avinty.instantie.assembler;

import java.util.ArrayList;
import java.util.List;

import com.avinty.instantie.dto.AlgemeenDto;
import com.avinty.instantie.entity.AlgemeenEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class AlgemeenAssemblerTest {

    @Mock
    AlgeMeenMapper mapper;

    private AlgemeenAssembler assembler;

    @Mock
    AlgemeenEntity entity = new AlgemeenEntity();

    @Mock
    AlgemeenDto dto = new AlgemeenDto();

    @BeforeEach
    public void setup() {
        openMocks(this);
        assembler = new AlgemeenAssembler(mapper);
    }

    @Test
    void toResourcesNullTest() {
        List<AlgemeenDto> dtos = assembler.toResources(null);
        Assertions.assertNotNull(dtos);
        Assertions.assertTrue(dtos.isEmpty());
    }

    @Test
    void toResourceNullTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AlgemeenDto dto = assembler.toResource(null);
        });
        Assertions.assertNotNull(exception);
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    void toResourcesTest() {

        when(mapper.to(entity)).thenReturn(dto);

        List<AlgemeenEntity> entities = new ArrayList<>();
        entities.add(entity);
        entities.add(null);

        List<AlgemeenDto> dtos = assembler.toResources(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertFalse(dtos.isEmpty());
        Assertions.assertEquals(1, dtos.size());
        Assertions.assertEquals(dtos.get(0), dto);

        verify(mapper, times(1)).to(eq(entity));
    }

    @Test
    void toEntityTest() {

        when(mapper.create(dto))
                .thenReturn(entity);

        AlgemeenEntity newEntity = assembler.toEntity(dto, null);
        Assertions.assertEquals(entity, newEntity);

        verify(mapper, times(1))
                .create(dto);
    }

}
