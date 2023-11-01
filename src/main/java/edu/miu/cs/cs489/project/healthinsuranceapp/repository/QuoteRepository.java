package edu.miu.cs.cs489.project.healthinsuranceapp.repository;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
//    List<Quote> findAllByCustomerId(Long customerId);
//    void  deleteAllQuotesByCustomerId(Long customerId);
}
