package edu.miu.cs.cs489.healthinsurancesys.dto.customer;

import edu.miu.cs.cs489.healthinsurancesys.dto.policy.PolicyRequest;

import java.util.List;

public record CustomerRequest(
        String firstName,
        String lastName
) { }
