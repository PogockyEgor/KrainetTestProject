package com.KrainetTestProject.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestRequest {

    private String name;
    private String description;
    private List<Integer> directions;
}
