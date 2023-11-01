package edu.miu.cs.cs489.project.healthinsuranceapp.repository;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}
