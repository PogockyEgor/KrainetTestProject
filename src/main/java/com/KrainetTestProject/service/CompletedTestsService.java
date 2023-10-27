package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.CompletedTests;

import java.util.List;

public interface CompletedTestsService {

    List<CompletedTests> getAllTests();
    void createCompletedTest(CompletedTests completedTests);
    void updateCompletedTest(CompletedTests completedTests);
}
