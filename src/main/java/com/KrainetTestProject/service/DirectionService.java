package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.request.DirectionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DirectionService {

    Page<Direction> getAllDirections(Pageable pageable);
    Page<Direction> getAllDirectionsFromFirstToLast(int first, int last, Pageable pageable);

    void createDirection(DirectionRequest direction);

    void updateDirection(Direction direction);
}
