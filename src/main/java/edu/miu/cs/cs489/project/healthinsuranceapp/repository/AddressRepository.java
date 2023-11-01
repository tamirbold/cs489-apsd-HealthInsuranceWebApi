package edu.miu.cs.cs489.project.healthinsuranceapp.repository;


import edu.miu.cs.cs489.project.healthinsuranceapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
