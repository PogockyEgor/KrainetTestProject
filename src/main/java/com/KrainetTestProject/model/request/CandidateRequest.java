package com.KrainetTestProject.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
