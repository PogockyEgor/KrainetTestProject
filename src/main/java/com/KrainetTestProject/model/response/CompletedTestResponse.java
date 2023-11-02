package com.KrainetTestProject.model.response;

import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.model.domain.TestResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedTestResponse {

    private Candidate candidate;
    private Test test;
    private Set<TestResult> testResult;
}
