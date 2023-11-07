package com.KrainetTestProject.controllers;

import com.KrainetTestProject.model.request.CompletedTestRequest;
import com.KrainetTestProject.model.response.CompletedTestResponse;
import com.KrainetTestProject.service.CompletedTestService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/completedTest")
public class CompletedTestController {

    CompletedTestService completedTestService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CompletedTestController(CompletedTestService completedTestService) {
        this.completedTestService = completedTestService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<?> getAllCompletedTests(@PageableDefault Pageable pageable,
                                                                @RequestParam int first,
                                                                @RequestParam int last) {
        logger.info("get request to /completedTest");
        Page<CompletedTestResponse> completedTestResponses = completedTestService.getAllTests(first, last, pageable);
        return new ResponseEntity<>(completedTestResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCompletedTest(@RequestBody CompletedTestRequest completedTestRequest) {
        logger.info("post request to /completedTest");
        completedTestService.createCompletedTest(completedTestRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> createCompletedTest(@RequestBody CompletedTestRequest completedTestRequest,
                                                 @RequestParam int completedTestId) {
        logger.info("put request to /completedTest");
        completedTestService.updateCompletedTest(completedTestRequest, completedTestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
