package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.repository.TestRepository;
import com.KrainetTestProject.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestsService {

    TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getAllTests() {
        return null;
    }

    @Override
    public void createTest(Test test) {

    }

    @Override
    public void updateTest(Test test) {

    }
}
