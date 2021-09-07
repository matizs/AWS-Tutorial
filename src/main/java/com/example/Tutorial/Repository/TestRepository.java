package com.example.Tutorial.Repository;

import com.example.Tutorial.Model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestModel, Long> {
}
