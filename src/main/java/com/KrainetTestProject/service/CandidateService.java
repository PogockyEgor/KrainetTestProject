package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.request.CandidateRequest;
import com.KrainetTestProject.model.response.CandidateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandidateService {

    Page<CandidateResponse> getAllCandidates(int first, int last, Pageable pageable);
    void createCandidate(MultipartFile cv, MultipartFile photo, CandidateRequest candidateRequest) throws IOException;
    void updateCandidate(Candidate candidate);
}
