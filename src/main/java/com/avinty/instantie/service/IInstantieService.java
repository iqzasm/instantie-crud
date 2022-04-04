package com.avinty.instantie.service;

import java.util.List;

import com.avinty.instantie.dto.InstantieDto;

public interface IInstantieService {

    List<InstantieDto> getActiveInstantie(Long instCategorie);

    InstantieDto save(InstantieDto instantieDto);
}
