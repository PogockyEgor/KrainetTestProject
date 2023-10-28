package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.model.domain.CompletedTests;
import com.KrainetTestProject.repository.CompletedTestsRepository;
import com.KrainetTestProject.service.CompletedTestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletedTestsImpl implements CompletedTestsService {

    CompletedTestsRepository completedTestsRepository;

    @Autowired
    public CompletedTestsImpl(CompletedTestsRepository completedTestsRepository) {
        this.completedTestsRepository = completedTestsRepository;
    }

    @Override
    public List<CompletedTests> getAllTests() {
        return null;
    }

    @Override
    public void createCompletedTest(CompletedTests completedTests) {

    }

    @Override
    public void updateCompletedTest(CompletedTests completedTests) {

    }
}
