package edu.miu.cs.cs489.healthinsurancesys.controller;

import edu.miu.cs.cs489.healthinsurancesys.dto.policy.PolicyResponse;
import edu.miu.cs.cs489.healthinsurancesys.model.Policy;
import edu.miu.cs.cs489.healthinsurancesys.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/insurance/policies")
public class PolicyController {
    private final PolicyService policyService;
    public PolicyController(PolicyService policyService){
        this.policyService = policyService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<PolicyResponse>> getAllPolicies(){
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping(value = "/prime-policies")
    public ResponseEntity<List<PolicyResponse>> getAllPrimePolicies(){
        return ResponseEntity.ok(policyService.getAllPrimePolicies());
    }

    @PostMapping("/update/{policyId}")
    public ResponseEntity<Policy> updatePolicy(
            @PathVariable Long policyId,
            @RequestBody Policy updatedPolicy
    ) {
        Policy updated = policyService.updatePolicy(policyId, updatedPolicy);
//        PolicyResponse response = new PolicyResponse(
//                updated.getPolicyId(),
//                updated.getPolicyNumber(),
//                updated.getPolicyType(),
//                updated.getDateOpened(),
//                new CustomerResponse(
//                        updated.getCustomer().getCustomerId(),
//                        updated.getCustomer().getFirstName(),
//                        updated.getCustomer().getLastName()
//                )
//        );
        return ResponseEntity.ok(updated);
    }

//    @PutMapping(value = {"/update/{productNo}"})
//    public ResponseEntity<Product> updateProduct(@PathVariable  Long productNo, @RequestBody Product product){
//        return new ResponseEntity<>(productService.updateProductByProductNo(productNo, product),
//                HttpStatus.OK);
//    }
}
