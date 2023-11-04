package edu.miu.cs.cs489.healthinsurancesys.dto.policy;

import java.time.LocalDate;

public record PolicyRequest(
        String policyNumber,
        String policyType,
        LocalDate dateOpened
) {}
