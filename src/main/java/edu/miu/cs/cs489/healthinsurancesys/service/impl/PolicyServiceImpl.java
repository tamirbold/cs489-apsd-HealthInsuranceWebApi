package edu.miu.cs.cs489.healthinsurancesys.service.impl;


import edu.miu.cs.cs489.healthinsurancesys.dto.policy.PolicyResponse;
import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerResponse;
import edu.miu.cs.cs489.healthinsurancesys.model.Policy;
import edu.miu.cs.cs489.healthinsurancesys.repository.PolicyRepository;
import edu.miu.cs.cs489.healthinsurancesys.service.PolicyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {
    private final PolicyRepository policyRepository;
    public PolicyServiceImpl(PolicyRepository policyRepository){
        this.policyRepository = policyRepository;
    }
    @Override
    public List<PolicyResponse> getAllPolicies() {
        return policyRepository.findAll(Sort.by("dateOpened")).stream()
                .map(p -> new PolicyResponse(p.getPolicyId(), p.getPolicyNumber(), p.getPolicyType(), p.getDateOpened(),
                        new CustomerResponse(p.getCustomer().getCustomerId(), p.getCustomer().getFirstName(), p.getCustomer().getLastName()))).toList();
    }

    @Override
    public List<PolicyResponse> getAllPrimePolicies() {
        return policyRepository.findAll().stream()
                .filter(Policy::isPrimePolicy)
                .map(p -> new PolicyResponse(p.getPolicyId(), p.getPolicyNumber(), p.getPolicyType(), p.getDateOpened(),
                        new CustomerResponse(p.getCustomer().getCustomerId(), p.getCustomer().getFirstName(), p.getCustomer().getLastName()))).toList();
    }

    @Override
    public Policy updatePolicy(Long policyId, Policy updatedPolicy) {
        Optional<Policy> existingPolicyOptional = policyRepository.findById(policyId);
        if (existingPolicyOptional.isEmpty()) {
            throw new EntityNotFoundException("Policy with id " + policyId + " not found");
        }

        Policy existingPolicy = existingPolicyOptional.get();

        updatedPolicy.setCustomer(existingPolicy.getCustomer());

        existingPolicy.setPolicyNumber(updatedPolicy.getPolicyNumber());
        existingPolicy.setPolicyType(updatedPolicy.getPolicyType());
        existingPolicy.setDateOpened(updatedPolicy.getDateOpened());

        return policyRepository.save(existingPolicy);
    }




//    public Product updateProductByProductNo (Long productNo, Product editedProduct) {
//        var product = productRepository.findProductByProductNo(productNo)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid ProductNo"));
//        product.setName(editedProduct.getName());
//        product.setUnitPrice(editedProduct.getUnitPrice());
//        product.setQuantityInStock(editedProduct.getQuantityInStock());
//        product.setDateSupplied(editedProduct.getDateSupplied());
//        return productRepository.save(product);
//    }
}

