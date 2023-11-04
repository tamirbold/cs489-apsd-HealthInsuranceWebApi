package edu.miu.cs.cs489.healthinsurancesys.dto.policy;

import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerResponse;
import edu.miu.cs.cs489.healthinsurancesys.model.Policy;

import java.time.LocalDate;
import java.util.List;

public record PolicyResponse(
        Long policytId,
        String policyNumber,
        String policyType,
        LocalDate dateOpened,
        CustomerResponse customerResponse
) { }

