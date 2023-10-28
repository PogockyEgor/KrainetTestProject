package com.KrainetTestProject.repository;

import com.KrainetTestProject.model.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
