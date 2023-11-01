package edu.miu.cs.cs489.project.healthinsuranceapp.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
