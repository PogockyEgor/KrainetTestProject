package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.model.request.TestRequest;
import com.KrainetTestProject.model.response.TestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TestsService {

    Page<TestResponse> getAllTests(int first, int last, Pageable pageable);
    void createTest(TestRequest testRequest);
    void updateTest(TestRequest testRequest, int id);
}
