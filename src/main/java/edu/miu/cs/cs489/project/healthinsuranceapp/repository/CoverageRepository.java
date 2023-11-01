package edu.miu.cs.cs489.project.healthinsuranceapp.repository;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Coverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverageRepository extends JpaRepository<Coverage, Long> {
}
