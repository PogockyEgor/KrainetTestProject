package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.mappers.DirectionMapper;
import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.request.DirectionRequest;
import com.KrainetTestProject.model.response.DirectionResponse;
import com.KrainetTestProject.repository.DirectionRepository;
import com.KrainetTestProject.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    DirectionRepository directionRepository;
    DirectionMapper directionMapper;

    @Autowired
    public DirectionServiceImpl(DirectionRepository directionRepository, DirectionMapper directionMapper) {
        this.directionRepository = directionRepository;
        this.directionMapper = directionMapper;
    }

    @Override
    public Page<Direction> getAllDirections(Pageable pageable) {
        /*ArrayList<DirectionResponse> directionResponses = new ArrayList<>();
        for (Direction direction : directions){
            directionResponses.add(directionMapper.fromDirectionToDirectionResponse(direction));
        }*/
        return directionRepository.findAll(pageable);
    }

    @Override
    public Page<DirectionResponse> getAllDirectionsFromFirstToLast(int first, int last, Pageable pageable) {
        List<Direction> directions = directionRepository.findAllByIdBetween(first, last, pageable).getContent();
        ArrayList<DirectionResponse> directionResponses = new ArrayList<>();
        for (Direction direction : directions){
            directionResponses.add(directionMapper.fromDirectionToDirectionResponse(direction));
        }
        Page<DirectionResponse> directionResponsePage = new PageImpl<>(directionResponses, pageable,directionResponses.size());
        return directionResponsePage;
    }

    @Override
    public void createDirection(DirectionRequest directionRequest) {
        directionRepository.save(directionMapper.fromDirectionRequestToDirection(directionRequest));
    }

    @Override
    public void updateDirection(Direction direction) {
        directionRepository.save(direction);
    }
}
