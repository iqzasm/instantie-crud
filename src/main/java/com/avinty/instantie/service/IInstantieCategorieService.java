package com.avinty.instantie.service;

import java.util.List;

import com.avinty.instantie.dto.InstantieCategorieDto;

public interface IInstantieCategorieService {

    List<InstantieCategorieDto> getActiveInstantieCategorie(String incaNaam, Boolean isFilterByName);

    InstantieCategorieDto save(InstantieCategorieDto categorieDto);

    void delete(Long id);
}
