package com.KrainetTestProject.controllers;

import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.request.DirectionRequest;
import com.KrainetTestProject.model.response.DirectionResponse;
import com.KrainetTestProject.service.Imp.DirectionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/direction")
public class DirectionController {

    DirectionServiceImpl directionService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public DirectionController(DirectionServiceImpl directionService) {
        this.directionService = directionService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDirectories(@PageableDefault Pageable pageable,
                                               @RequestParam int first,
                                               @RequestParam int last) {
        logger.info("get request to /direction");
        Page<DirectionResponse> allDirections = directionService.getAllDirectionsFromFirstToLast(first, last, pageable);
        return new ResponseEntity<>(allDirections, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDirection(@RequestBody DirectionRequest direction) {
        logger.info("post request to /direction");
        directionService.createDirection(direction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateDirection(@RequestBody Direction direction) {
        logger.info("put request to /direction");
        directionService.updateDirection(direction);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
