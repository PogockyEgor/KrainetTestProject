package com.KrainetTestProject.controllers;

import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.request.CandidateRequest;
import com.KrainetTestProject.model.response.CandidateResponse;
import com.KrainetTestProject.service.Imp.CandidateServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    CandidateServiceImpl candidateService;

    public CandidateController(CandidateServiceImpl candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<?> getAllCandidates(@PageableDefault Pageable pageable,
                                                            @RequestParam int first,
                                                            @RequestParam int last) {
        Page<CandidateResponse> candidates = candidateService.getAllCandidates(first, last, pageable);
        //InputStream in = getClass().getResourceAsStream("uploads/PogockyEgor_CV");
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCandidate(@RequestPart("cv") MultipartFile cv,
                                             @RequestPart("photo") MultipartFile photo,
                                             @RequestParam("json") String candidateJSON) throws IOException {
        CandidateRequest candidateRequest = new ObjectMapper().readValue(candidateJSON, CandidateRequest.class);
        candidateService.createCandidate(cv, photo, candidateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCandidate(Candidate candidate,
                                             @RequestParam("file") MultipartFile file) {
        candidateService.updateCandidate(candidate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
