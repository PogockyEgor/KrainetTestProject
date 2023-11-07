package com.KrainetTestProject.model.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRequest {

    private String lastname;
    private String firstname;
    private String secondname;
    private String photo;
    private String description;
    private String cv;
    private List<Integer> directions;
}
