package com.avinty.instantie.repository;

import com.avinty.instantie.entity.AlgemeenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgemeenRepository extends JpaRepository<AlgemeenEntity, Long> {
}
