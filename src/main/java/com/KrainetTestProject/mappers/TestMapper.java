package com.KrainetTestProject.mappers;

import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.model.request.TestRequest;
import com.KrainetTestProject.model.response.DirectionResponse;
import com.KrainetTestProject.model.response.TestResponse;
import org.springframework.stereotype.Component;

@Component
public class TestMapper {

    public Test fromTestRequestToTest(TestRequest testRequest){
        Test test = new Test();
        test.setName(testRequest.getName());
        test.setDescription(testRequest.getDescription());
        return test;
    }

    public TestResponse fromDirectionToDirectionResponse(Test test){
        TestResponse testResponse = new TestResponse();
        testResponse.setName(test.getName());
        testResponse.setDescription(test.getDescription());
        for (Direction direction : test.getDirectionList()){
            direction.setTestList(null);
            direction.setCandidateList(null);
        }
        testResponse.setDirectionList(test.getDirectionList());
        return testResponse;
    }
}
