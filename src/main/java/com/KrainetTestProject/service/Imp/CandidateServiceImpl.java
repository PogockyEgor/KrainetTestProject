package com.KrainetTestProject.service.Imp;

import com.KrainetTestProject.mappers.CandidateMapper;
import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.request.CandidateRequest;
import com.KrainetTestProject.model.response.CandidateResponse;
import com.KrainetTestProject.repository.CandidateRepository;
import com.KrainetTestProject.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    CandidateRepository candidateRepository;
    CandidateMapper candidateMapper;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository, CandidateMapper candidateMapper) {
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
    }

    @Override
    public Page<CandidateResponse> getAllCandidates(int first, int last, Pageable pageable) {
        List<Candidate> candidates = candidateRepository.findAllByIdBetween(first, last, pageable).getContent();
        ArrayList<CandidateResponse> candidateResponses = new ArrayList<>();
        for (Candidate candidate : candidates) {
            candidateResponses.add(candidateMapper.fromCandidateToCandidateResponse(candidate));
        }
        return new PageImpl<>(candidateResponses, pageable, candidateResponses.size());
    }

    @Override
    public void createCandidate(MultipartFile cv, MultipartFile photo, CandidateRequest candidateRequest) throws IOException {
        String cvPathname = "C:\\Users\\user\\IdeaProjects\\KrainetTestProject\\src\\main\\resources\\uploads\\"
                + candidateRequest.getLastname() + candidateRequest.getFirstname() + "_CV";
        String photoPathname = "C:\\Users\\user\\IdeaProjects\\KrainetTestProject\\src\\main\\resources\\uploads\\"
                + candidateRequest.getLastname() + candidateRequest.getFirstname() + "_Photo";
        candidateRequest.setCv(cvPathname);
        candidateRequest.setPhoto(photoPathname);
        cv.transferTo(new File(cvPathname));
        photo.transferTo(new File(photoPathname));
        Candidate candidate = candidateMapper.fromCandidateRequestToCandidate(candidateRequest);
        System.out.println(candidate);
        candidateRepository.save(candidateMapper.fromCandidateRequestToCandidate(candidateRequest));
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }
}
