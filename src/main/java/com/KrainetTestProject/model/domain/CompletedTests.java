package com.KrainetTestProject.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "completedTests")
public class CompletedTests {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "completedTests_id_seq_gen")
    @SequenceGenerator(name = "completedTests_id_seq_gen", sequenceName = "completedTests_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "grade")
    private int grade;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
}
