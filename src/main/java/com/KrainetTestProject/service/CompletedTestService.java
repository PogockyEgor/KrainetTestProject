package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.CompletedTest;
import com.KrainetTestProject.model.request.CompletedTestRequest;
import com.KrainetTestProject.model.response.CompletedTestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompletedTestService {

    Page<CompletedTestResponse> getAllTests(int first, int last, Pageable pageable);
    void createCompletedTest(CompletedTestRequest completedTestsRequest);
    void updateCompletedTest(CompletedTest completedTests);
}
