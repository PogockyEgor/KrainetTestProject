package com.KrainetTestProject.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_id_seq_gen")
    @SequenceGenerator(name = "candidate_id_seq_gen", sequenceName = "candidate_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @Column(name = "cv")
    private String cv;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "l_directions_candidates",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "direction_id"))
    private List<Direction> directionList = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private Set<CompletedTest> completedTests = new HashSet<>();
}
