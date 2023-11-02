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

@Entity
@Table(name = "test_result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResult {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testResult_id_seq_gen")
    @SequenceGenerator(name = "testResult_id_seq_gen", sequenceName = "testResult_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "grade")
    private int grade;

    @ManyToOne
    @JoinColumn(name = "completed_test_id", nullable = false)
    private CompletedTest completedTest;
}
