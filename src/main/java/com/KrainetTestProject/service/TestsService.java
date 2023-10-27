package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Test;

import java.util.List;

public interface TestsService {

    List<Test> getAllTests();
    Test getTest(int id);
    void createTest(Test test);
    void updateTest(Test test);
}
