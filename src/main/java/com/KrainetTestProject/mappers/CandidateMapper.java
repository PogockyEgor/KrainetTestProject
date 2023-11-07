package com.KrainetTestProject.mappers;

import com.KrainetTestProject.model.domain.Candidate;
import com.KrainetTestProject.model.domain.Direction;
import com.KrainetTestProject.model.request.CandidateRequest;
import com.KrainetTestProject.model.response.CandidateResponse;
import com.KrainetTestProject.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateMapper {

    DirectionRepository directionRepository;

    @Autowired
    public CandidateMapper(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    public Candidate fromCandidateRequestToCandidate(CandidateRequest candidateRequest) {
        Candidate candidate = new Candidate();
        candidate.setFirstname(candidateRequest.getFirstname());
        candidate.setLastname(candidateRequest.getLastname());
        candidate.setSecondname(candidateRequest.getSecondname());
        candidate.setDescription(candidateRequest.getDescription());
        candidate.setCv(candidateRequest.getCv());
        candidate.setPhoto(candidateRequest.getPhoto());
        List<Direction> directions = new ArrayList<>();
        for (Integer directionId : candidateRequest.getDirections()) {
            directions.add(directionRepository.findById(directionId).get());
        }
        directions.forEach(direction -> direction.setTestList(null));
        candidate.setDirectionList(directions);
        return candidate;
    }

    public CandidateResponse fromCandidateToCandidateResponse(Candidate candidate) {
        CandidateResponse candidateResponse = new CandidateResponse();
        candidateResponse.setFirstname(candidate.getFirstname());
        candidateResponse.setLastname(candidate.getLastname());
        candidateResponse.setSecondname(candidate.getSecondname());
        candidateResponse.setCv(new File(candidate.getCv()));
        candidateResponse.setPhoto(new File(candidate.getPhoto()));
        for (Direction direction : candidate.getDirectionList()) {
            direction.setCandidateList(null);
            direction.setTestList(null);
        }
        candidateResponse.setDirectionList(candidate.getDirectionList());
        return candidateResponse;
    }
}
