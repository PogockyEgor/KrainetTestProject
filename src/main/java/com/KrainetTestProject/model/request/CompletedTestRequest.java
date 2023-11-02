package com.KrainetTestProject.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedTestRequest {

    private int candidateId;
    private int testId;
}
