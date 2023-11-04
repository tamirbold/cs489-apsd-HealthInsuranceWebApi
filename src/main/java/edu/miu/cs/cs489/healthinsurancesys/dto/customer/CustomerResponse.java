package edu.miu.cs.cs489.healthinsurancesys.dto.customer;

public record CustomerResponse(
        int customerId,
        String firstName,
        String lastName
) { }
