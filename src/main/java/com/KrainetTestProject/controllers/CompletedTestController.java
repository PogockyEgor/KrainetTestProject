package com.KrainetTestProject.controllers;

import com.KrainetTestProject.model.response.CompletedTestResponse;
import com.KrainetTestProject.service.CompletedTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/completedTest")
public class CompletedTestController {

    CompletedTestService completedTestService;

    @Autowired
    public CompletedTestController(CompletedTestService completedTestService) {
        this.completedTestService = completedTestService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<?> getAllCompletedTests(@PageableDefault Pageable pageable,
                                                                @RequestParam int first,
                                                                @RequestParam int last) {
        Page<CompletedTestResponse> completedTestResponses = completedTestService.getAllTests(first, last, pageable);
        return new ResponseEntity<>(completedTestResponses, HttpStatus.OK);
    }
}
