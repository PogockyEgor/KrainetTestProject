package com.KrainetTestProject.model.response;

import com.KrainetTestProject.model.domain.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResponse {

    private String name;
    private String description;
    private List<Direction> directionList;

}
