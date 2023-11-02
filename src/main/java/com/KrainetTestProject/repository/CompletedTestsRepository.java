package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.CompletedTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedTestsRepository extends JpaRepository<CompletedTest, Integer> {

    Page<CompletedTest> findAllByIdBetween(int first, int last, Pageable pageable);
}
