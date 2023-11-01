package edu.miu.cs.cs489.project.healthinsuranceapp.repository;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
