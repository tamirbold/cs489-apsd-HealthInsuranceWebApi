package edu.miu.cs.cs489.project.healthinsuranceapp.service;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Quote;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Policy;

import java.util.List;

public interface QuoteService {
    public List<Quote> getAllQuote();
    public Quote getQuoteById(Long quoteId);
    //public List<Quote> getAllQuotesByCustomerId(Long customerId);
    public Quote updateQuote(Long quoteId, Quote quote);
    // public void deleteCustomerQuoteByCustomerId(Long customerId);
    public void deleteQuoteById(Long quoteId);
    public Quote addNewQuote(Quote quote);
}
