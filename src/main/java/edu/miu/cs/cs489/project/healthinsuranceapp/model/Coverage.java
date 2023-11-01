package edu.miu.cs.cs489.project.healthinsuranceapp.model;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coverages")
public class Coverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coverageId;
    private String coverageName;
    private Double coveragePrice;
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
}