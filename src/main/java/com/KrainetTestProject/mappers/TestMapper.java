package com.KrainetTestProject.mappers;

import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.model.request.TestRequest;
import com.KrainetTestProject.model.response.TestResponse;
import com.KrainetTestProject.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestMapper {

    DirectionRepository directionRepository;

    @Autowired
    public TestMapper(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    public Test fromTestRequestToTest(TestRequest testRequest) {
        Test test = new Test();
        test.setName(testRequest.getName());
        test.setDescription(testRequest.getDescription());
        List<Direction> directions = new ArrayList<>();
        for (Integer directionId : testRequest.getDirections()){
            directions.add(directionRepository.findById(directionId).get());
        }
        test.setDirectionList(directions);
        return test;
    }

    public TestResponse fromDirectionToDirectionResponse(Test test) {
        TestResponse testResponse = new TestResponse();
        testResponse.setName(test.getName());
        testResponse.setDescription(test.getDescription());
        for (Direction direction : test.getDirectionList()) {
            direction.setTestList(null);
            direction.setCandidateList(null);
        }
        testResponse.setDirectionList(test.getDirectionList());
        return testResponse;
    }
}
