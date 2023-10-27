package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Direction;

import java.util.List;

public interface DirectionService {

    List<Direction> getAllDirections();
    void createDirection(Direction direction);
    void updateDirection(Direction direction);
}
