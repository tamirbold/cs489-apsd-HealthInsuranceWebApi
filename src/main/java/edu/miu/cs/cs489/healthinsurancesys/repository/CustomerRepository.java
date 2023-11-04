package edu.miu.cs.cs489.healthinsurancesys.repository;


import edu.miu.cs.cs489.healthinsurancesys.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
