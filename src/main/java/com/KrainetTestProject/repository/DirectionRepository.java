package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Integer> {

    Page<Direction> findAll(Pageable pageable);
    Page<Direction> findAllByIdBetween(int first, int last, Pageable pageable);
}
