package com.avinty.instantie.repository;

import java.util.List;

import com.avinty.instantie.entity.InstantieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstantieRepository extends JpaRepository<InstantieEntity, Long> {

    @Query(" select i from InstantieEntity i where i.instCategorie.incaNummer = :instCategorie")
    List<InstantieEntity> findAllByInstantieCategory(@Param("instCategorie") Long instCategorie);
}
