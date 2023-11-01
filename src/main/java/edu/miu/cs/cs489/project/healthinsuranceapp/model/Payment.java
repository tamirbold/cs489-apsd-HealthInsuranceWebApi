package edu.miu.cs.cs489.project.healthinsuranceapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private LocalDate paymentDate;
    private Double paymentAmount;
    private String paymentType;
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
}
