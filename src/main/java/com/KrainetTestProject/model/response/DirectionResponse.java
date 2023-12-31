package com.KrainetTestProject.model.response;

import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.domain.Test;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectionResponse {

    private String name;
    private String description;
    private List<Test> tests;
    private List<Candidate> candidateList;
}