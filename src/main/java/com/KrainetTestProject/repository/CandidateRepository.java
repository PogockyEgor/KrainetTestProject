package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
