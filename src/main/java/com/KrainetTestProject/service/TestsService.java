package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Test;

import java.util.List;

public interface TestsService {

    List<Test> getAllTests();
    void createTest(Test test);
    void updateTest(Test test);
}
