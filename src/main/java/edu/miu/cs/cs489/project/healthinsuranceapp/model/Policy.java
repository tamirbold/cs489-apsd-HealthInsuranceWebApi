package edu.miu.cs.cs489.project.healthinsuranceapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String policyNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate effectiveDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiredDate;
    private Double totalAmount;
    private boolean active;
//    @OneToOne
//    private Vehicle vehicle;
    @OneToMany(mappedBy = "policy")
    private List<Coverage> coverages;
    @OneToMany(mappedBy = "policy")
    private List<Quote> quotes;
    @OneToMany(mappedBy = "policy")
    private List<Payment> payments;
}
