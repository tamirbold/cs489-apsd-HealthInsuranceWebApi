package edu.miu.cs.cs489.project.healthinsuranceapp.repository;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
