package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.mappers.CompletedTestMapper;
import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.domain.CompletedTest;
import com.KrainetTestProject.model.request.CompletedTestRequest;
import com.KrainetTestProject.model.response.CandidateResponse;
import com.KrainetTestProject.model.response.CompletedTestResponse;
import com.KrainetTestProject.repository.CompletedTestsRepository;
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

    @Autowired
    public CompletedTestImpl(CompletedTestsRepository completedTestsRepository, CompletedTestMapper completedTestMapper) {
        this.completedTestsRepository = completedTestsRepository;
        this.completedTestMapper = completedTestMapper;
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

    }

    @Override
    public void updateCompletedTest(CompletedTest completedTests) {

    }
}
