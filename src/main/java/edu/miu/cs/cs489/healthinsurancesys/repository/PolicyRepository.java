package edu.miu.cs.cs489.healthinsurancesys.repository;

import edu.miu.cs.cs489.healthinsurancesys.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

   // Optional<Policy> updatePolicyByPolicyNo(Long policyNo);

}
