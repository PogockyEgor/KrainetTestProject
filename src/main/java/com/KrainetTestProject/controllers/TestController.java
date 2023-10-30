package com.KrainetTestProject.controllers;

import com.KrainetTestProject.model.domain.Test;
import com.KrainetTestProject.model.request.TestRequest;
import com.KrainetTestProject.model.response.TestResponse;
import com.KrainetTestProject.service.Imp.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/test")
public class TestController {

    TestServiceImpl testService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TestController(TestServiceImpl testService) {
        this.testService = testService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDirectories(@PageableDefault Pageable pageable,
                                               @RequestParam int first,
                                               @RequestParam int last) {
        logger.info("get request to /test");
        Page<TestResponse> allTests = testService.getAllTests(first, last, pageable);
        return new ResponseEntity<>(allTests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDirection(@RequestBody TestRequest testRequest) {
        logger.info("post request to /test");
        testService.createTest(testRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateDirection(@RequestBody Test test) {
        logger.info("put request to /test");
        testService.updateTest(test);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
