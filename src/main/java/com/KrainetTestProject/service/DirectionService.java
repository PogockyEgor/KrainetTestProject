package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.request.DirectionRequest;
import com.KrainetTestProject.model.response.DirectionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DirectionService {

    Page<Direction> getAllDirections(Pageable pageable);
    Page<DirectionResponse> getAllDirectionsFromFirstToLast(int first, int last, Pageable pageable);

    void createDirection(DirectionRequest direction);

    void updateDirection(Direction direction);
}
