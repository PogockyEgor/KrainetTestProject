package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.CompletedTest;
import com.KrainetTestProject.model.domain.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TestResultRepository extends JpaRepository<TestResult, Integer> {

    Set<TestResult> findAllByCompletedTest(CompletedTest completedTest);
}
