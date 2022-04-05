package com.avinty.instantie.controller;

import com.avinty.instantie.dto.AlgemeenDto;
import com.avinty.instantie.dto.InstantieCategorieDto;
import com.avinty.instantie.dto.InstantieDto;
import com.avinty.instantie.exception.NotFoundException;
import com.avinty.instantie.service.IAlgemeenService;
import com.avinty.instantie.service.IInstantieCategorieService;
import com.avinty.instantie.service.IInstantieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class InstantieController {

    private final IInstantieCategorieService instantieCategorieService;
    private final IInstantieService instantieService;
    private final IAlgemeenService algemeenService;

    public InstantieController(
            IInstantieCategorieService instantieCategorieService,
            IInstantieService instantieService,
            IAlgemeenService algemeenService) {
        this.instantieCategorieService = instantieCategorieService;
        this.instantieService = instantieService;
        this.algemeenService = algemeenService;
    }

    @GetMapping("/categorie")
    public ResponseEntity<List<InstantieCategorieDto>> getAll(@RequestParam(value = "name", required = false) String incaNaame) {

        log.info("start getAll categorie {}", this.getClass().getSimpleName());

        List<InstantieCategorieDto> instantieCategories =
                instantieCategorieService.getActiveInstantieCategorie(incaNaame, incaNaame != null);

        if (CollectionUtils.isEmpty(instantieCategories)) {
            throw new NotFoundException("No Active Instantie Categorie found for the given input");
        }

        return ResponseEntity.ok().body(instantieCategories);
    }

    @GetMapping("/categorie-instantie/{categoryId}")
    public ResponseEntity<List<InstantieDto>> getAllInstanties(@PathVariable("categoryId") Long categoryId) {

        log.info("start getAllInstanties {}", this.getClass().getSimpleName());

        List<InstantieDto> instanties = instantieService.getActiveInstantie(categoryId);

        if (CollectionUtils.isEmpty(instanties)) {
            throw new NotFoundException("No Active Instantie found for the given input");
        }

        return ResponseEntity.ok().body(instanties);
    }

    @PostMapping("/algemeen")
    public ResponseEntity<AlgemeenDto> saveAlgemeen(@RequestBody AlgemeenDto algemeenDto) {
        log.info("start saveAlgemeen {}", this.getClass().getSimpleName());
        return ResponseEntity.ok(algemeenService.save(algemeenDto));
    }

    @PostMapping("/categorie-instantie")
    public ResponseEntity<InstantieCategorieDto> saveInstantieCategorie(@RequestBody InstantieCategorieDto categorieDto) {
        log.info("start saveInstantieCategorie {}", this.getClass().getSimpleName());
        return ResponseEntity.ok(instantieCategorieService.save(categorieDto));
    }

    @PostMapping("/instantie")
    public ResponseEntity<InstantieDto> saveInstantie(@RequestBody InstantieDto instantieDto) {
        log.info("start saveInstantie {}", this.getClass().getSimpleName());
        return ResponseEntity.ok(instantieService.save(instantieDto));
    }

    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<String> deleteCategorie(@PathVariable("id") Long id) {
        log.info("start deleteCategorie {}", this.getClass().getSimpleName());
        instantieCategorieService.delete(id);
        return ResponseEntity.ok().body("Record Deleted Successfully");
    }
}
