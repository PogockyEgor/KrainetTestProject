package com.KrainetTestProject.mappers;

import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.request.DirectionRequest;
import com.KrainetTestProject.model.response.DirectionResponse;
import org.springframework.stereotype.Component;

@Component
public class DirectionMapper {

    public Direction fromDirectionRequestToDirection(DirectionRequest directionRequest){
        Direction direction = new Direction();
        direction.setName(directionRequest.getName());
        direction.setDescription(directionRequest.getDescription());
        return direction;
    }

    public DirectionResponse fromDirectionToDirectionResponse(Direction direction){
        DirectionResponse directionResponse = new DirectionResponse();
        directionResponse.setName(direction.getName());
        directionResponse.setDescription(direction.getDescription());
        return directionResponse;
    }
}
