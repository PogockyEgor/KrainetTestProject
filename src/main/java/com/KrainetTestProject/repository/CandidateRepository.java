package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Page<Candidate> findAllByIdBetween(int first, int last, Pageable pageable);
}
