package com.KrainetTestProject.model.request;

import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.model.domain.TestResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedTestRequest {

    private int candidateId;
    private int testId;
    private List<TestResult> testResults;
}
