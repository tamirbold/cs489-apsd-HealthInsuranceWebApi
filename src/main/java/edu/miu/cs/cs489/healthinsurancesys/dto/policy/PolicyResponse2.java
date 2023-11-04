package edu.miu.cs.cs489.healthinsurancesys.dto.policy;

import java.time.LocalDate;

public record PolicyResponse2(
        Long policyId,
        String policyNumber,
        String policyType,
        LocalDate policyOpened
) { }
