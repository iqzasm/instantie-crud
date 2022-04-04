package com.avinty.instantie.assembler;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractResourceAssembeler<E, R> {

    public abstract R toResource(E entity);

    public List<R> toResources(List<E> entities) {
        return entities == null ? Collections.emptyList() :
                (List) entities.stream().filter(Objects::nonNull)
                        .map(this::toResource).filter(Objects::nonNull)
                        .collect(Collectors.toList());
    }

    public abstract E toEntity(R var1, E var2);

}
