package com.KrainetTestProject.service;

import com.KrainetTestProject.model.domain.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> getAllCandidates();
    void createCandidate(Candidate candidate);
    void updateCandidate(Candidate candidate);
}
