package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {

    Page<Test> findAllByIdBetween(int first, int last, Pageable pageable);
}
