package com.KrainetTestProject.mappers;

import com.KrainetTestProject.model.domain.CompletedTest;
import com.KrainetTestProject.model.domain.TestResult;
import com.KrainetTestProject.model.request.CompletedTestRequest;
import com.KrainetTestProject.model.response.CompletedTestResponse;
import com.KrainetTestProject.repository.CandidateRepository;
import com.KrainetTestProject.repository.TestRepository;
import com.KrainetTestProject.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CompletedTestMapper {

    CandidateRepository candidateRepository;
    TestRepository testRepository;
    TestResultRepository testResultRepository;

    @Autowired
    public CompletedTestMapper(CandidateRepository candidateRepository, TestRepository testRepository,
                               TestResultRepository testResultRepository) {
        this.candidateRepository = candidateRepository;
        this.testRepository = testRepository;
        this.testResultRepository = testResultRepository;
    }

    public CompletedTest fromCompletedTestRequestToCompletedTest(CompletedTestRequest completedTestRequest) {
        CompletedTest completedTest = new CompletedTest();
        completedTest.setCandidate(candidateRepository.findById(completedTestRequest.getCandidateId()).get());
        completedTest.setTest(testRepository.findById(completedTestRequest.getTestId()).get());
        return completedTest;
    }

    public CompletedTestResponse fromCompletedTestToCompletedTestResponse(CompletedTest completedTest) {
        CompletedTestResponse completedTestResponse = new CompletedTestResponse();
        completedTest.getTest().setDirectionList(null);
        completedTest.getCandidate().setCompletedTests(null);
        completedTest.getCandidate().setDirectionList(null);
        //completedTest.getTestResults().forEach(testResult -> testResult.setCompletedTest(null));
        completedTestResponse.setTest(completedTest.getTest());
        completedTestResponse.setCandidate(completedTest.getCandidate());
        Set<TestResult> testResults = testResultRepository.findAllByCompletedTest(completedTest);
        testResults.forEach(testResult -> testResult.setCompletedTest(null));
        completedTestResponse.setTestResult(testResults);
        return completedTestResponse;
    }
}
