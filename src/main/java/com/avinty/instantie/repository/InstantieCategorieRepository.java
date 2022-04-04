package com.avinty.instantie.repository;

import java.util.List;

import com.avinty.instantie.entity.InstantieCategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstantieCategorieRepository extends JpaRepository<InstantieCategorieEntity, Long> {

    @Query(value = "SELECT * FROM INSTANTIE_CATEGORIE I " +
            "LEFT OUTER JOIN ALGEMEEN A ON A.ALGM_NUMMER = I.INCA_TYPE " +
            "WHERE TRUNC(SYSDATE) BETWEEN TRUNC(A.ALGM_STARTDATUM) AND COALESCE (TRUNC(A.ALGM_ENDDATUM),TO_DATE('31-12-9999' ,'dd-mm-yyyy'))",
            nativeQuery = true)
    List<InstantieCategorieEntity> findActiveCategories();

    @Query(value = "SELECT * FROM INSTANTIE_CATEGORIE I " +
            "LEFT OUTER JOIN ALGEMEEN A ON A.ALGM_NUMMER = I.INCA_TYPE " +
            "WHERE UPPER (I.INCA_NAAM) LIKE CONCAT('%', UPPER(:P_NAAM), '%') AND TRUNC(SYSDATE) " +
            "BETWEEN TRUNC(A.ALGM_STARTDATUM) AND COALESCE(TRUNC(A.ALGM_ENDDATUM),TO_DATE('31-12-9999' ,'dd-mm-yyyy'))",
            nativeQuery = true)
    List<InstantieCategorieEntity> findCategoryByName(@Param("P_NAAM") String incaNaam);

}
