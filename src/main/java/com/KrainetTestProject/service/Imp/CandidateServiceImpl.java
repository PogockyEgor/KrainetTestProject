package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.repository.CandidateRepository;
import com.KrainetTestProject.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return null;
    }

    @Override
    public void createCandidate(Candidate candidate) {

    }

    @Override
    public void updateCandidate(Candidate candidate) {

    }
}
