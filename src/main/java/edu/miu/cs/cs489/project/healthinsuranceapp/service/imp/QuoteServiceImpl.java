package edu.miu.cs.cs489.project.healthinsuranceapp.service.imp;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Quote;
import edu.miu.cs.cs489.project.healthinsuranceapp.repository.QuoteRepository;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {
    private QuoteRepository quoteRepository;
    public QuoteServiceImpl(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }
    @Override
    public List<Quote> getAllQuote() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        return quoteRepository.findById(quoteId)
                .orElse(null);
    }

//    @Override
//    public List<Quote> getAllQuotesByCustomerId(Long customerId) {
//
//        return quoteRepository.findAllByCustomerId(customerId);
//    }

    @Override
    public Quote updateQuote(Long quoteId, Quote quote) {
        return quoteRepository.save(quote);
    }

//    @Override
//    public void deleteCustomerQuoteByCustomerId(Long customerId) {
//        quoteRepository.deleteAllQuotesByCustomerId(customerId);
//    }

    @Override
    public void deleteQuoteById(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    @Override
    public Quote addNewQuote(Quote quote) {
        return quoteRepository.save(quote);
    }
}
