package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.mappers.CompletedTestMapper;
import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.domain.CompletedTest;
import com.KrainetTestProject.model.domain.TestResult;
import com.KrainetTestProject.model.request.CompletedTestRequest;
import com.KrainetTestProject.model.response.CandidateResponse;
import com.KrainetTestProject.model.response.CompletedTestResponse;
import com.KrainetTestProject.repository.CompletedTestsRepository;
import com.KrainetTestProject.repository.TestResultRepository;
import com.KrainetTestProject.service.CompletedTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompletedTestImpl implements CompletedTestService {

    CompletedTestsRepository completedTestsRepository;
    CompletedTestMapper completedTestMapper;
    TestResultRepository testResultRepository;

    @Autowired
    public CompletedTestImpl(CompletedTestsRepository completedTestsRepository, CompletedTestMapper completedTestMapper,
                             TestResultRepository testResultRepository) {
        this.completedTestsRepository = completedTestsRepository;
        this.completedTestMapper = completedTestMapper;
        this.testResultRepository = testResultRepository;
    }

    @Override
    public Page<CompletedTestResponse> getAllTests(int first, int last, Pageable pageable) {
        List<CompletedTest> completedTests = completedTestsRepository.findAllByIdBetween(first, last, pageable).getContent();
        ArrayList<CompletedTestResponse> completedTestResponses = new ArrayList<>();
        for (CompletedTest completedTest : completedTests) {
            completedTestResponses.add(completedTestMapper.fromCompletedTestToCompletedTestResponse(completedTest));
        }
        return new PageImpl<>(completedTestResponses, pageable, completedTestResponses.size());
    }

    @Override
    public void createCompletedTest(CompletedTestRequest completedTestRequest) {
        completedTestsRepository.save(completedTestMapper.fromCompletedTestRequestToCompletedTest(completedTestRequest));
        int completedTestId = completedTestsRepository.getLastCreatedCompletedTestId();
        for (TestResult testResult : completedTestRequest.getTestResults()){
            testResult.setCompletedTest(completedTestsRepository.findById(completedTestId).get());
        }
        testResultRepository.saveAll(completedTestRequest.getTestResults());
    }

    @Override
    public void updateCompletedTest(CompletedTestRequest completedTestRequest, int completedTestId) {
        CompletedTest completedTest = completedTestMapper.fromCompletedTestRequestToCompletedTest(completedTestRequest);
        completedTest.setId(completedTestId);
        completedTestsRepository.save(completedTest);
        for (TestResult testResult : completedTestRequest.getTestResults()){
            testResult.setCompletedTest(completedTestsRepository.findById(completedTest.getId()).get());
        }
        testResultRepository.saveAll(completedTestRequest.getTestResults());
    }
}
