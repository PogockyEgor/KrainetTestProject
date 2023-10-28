package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.CompletedTests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedTestsRepository extends JpaRepository<CompletedTests, Integer> {
}
