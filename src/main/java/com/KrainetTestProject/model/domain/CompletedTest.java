package com.KrainetTestProject.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "completed_tests")
public class CompletedTest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "completed_tests_id_seq_gen")
    @SequenceGenerator(name = "completed_tests_id_seq_gen", sequenceName = "completed_tests_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @OneToMany(mappedBy = "completedTest", fetch = FetchType.LAZY)
    private Set<TestResult> testResults = new HashSet<>();
}
