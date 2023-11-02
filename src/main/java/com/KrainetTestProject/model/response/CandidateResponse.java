package com.KrainetTestProject.model.response;

import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.domain.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponse {

    private String lastname;
    private String firstname;
    private String secondname;
    private File photo;
    private String description;
    private File cv;
    private List<Direction> directionList;

}
