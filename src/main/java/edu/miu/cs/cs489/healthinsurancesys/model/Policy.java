package edu.miu.cs.cs489.healthinsurancesys.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String policyNumber;
    @NotBlank
    @Column(nullable = false)
    private String policyType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(nullable = false)
    private LocalDate dateOpened;

    @OneToOne
    private Customer customer;


    public boolean isPrimePolicy(){
        Period period = Period.between(dateOpened, LocalDate.now());
        int totalYears = period.getYears();
        return (policyType.equals("gold") && totalYears >= 5);
    }

    public Policy(String policyNumber, String policyType, LocalDate dateOpened) {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.dateOpened = dateOpened;
    }
}
