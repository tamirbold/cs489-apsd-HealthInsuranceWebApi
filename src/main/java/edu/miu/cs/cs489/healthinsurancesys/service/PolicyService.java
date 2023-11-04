package edu.miu.cs.cs489.healthinsurancesys.service;

import edu.miu.cs.cs489.healthinsurancesys.dto.policy.PolicyResponse;
import edu.miu.cs.cs489.healthinsurancesys.model.Policy;

import java.util.List;

public interface PolicyService {

    List<PolicyResponse> getAllPolicies();
    List<PolicyResponse> getAllPrimePolicies();
    Policy updatePolicy(Long policyId, Policy updatedPolicy);

}
