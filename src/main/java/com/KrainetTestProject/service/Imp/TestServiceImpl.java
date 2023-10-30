package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.mappers.TestMapper;
import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.model.request.TestRequest;
import com.KrainetTestProject.model.response.TestResponse;
import com.KrainetTestProject.repository.TestRepository;
import com.KrainetTestProject.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestsService {

    TestRepository testRepository;
    TestMapper testMapper;

    @Autowired
    public TestServiceImpl(TestRepository testRepository, TestMapper testMapper) {
        this.testRepository = testRepository;
        this.testMapper = testMapper;
    }

    @Override
    public Page<TestResponse> getAllTests(int first, int last, Pageable pageable) {
        List<Test> tests = testRepository.findAllByIdBetween(first, last, pageable).getContent();
        ArrayList<TestResponse> testResponses = new ArrayList<>();
        for (Test test : tests) {
            testResponses.add(testMapper.fromDirectionToDirectionResponse(test));
        }
        Page<TestResponse> testResponsePage = new PageImpl<>(testResponses, pageable, testResponses.size());
        return testResponsePage;
    }

    @Override
    public void createTest(TestRequest testRequest) {
        testRepository.save(testMapper.fromTestRequestToTest(testRequest));
    }

    @Override
    public void updateTest(Test test) {
        testRepository.save(test);
    }
}
