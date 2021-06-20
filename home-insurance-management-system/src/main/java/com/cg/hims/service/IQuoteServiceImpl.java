package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.repository.IQuoteRepository;

@Service
public class IQuoteServiceImpl implements IQuoteService{
	
	@Autowired
	private IQuoteRepository quoteRepo;

	@Override
	public Quote addQuote(Quote quote) {
		
		return quoteRepo.save(quote);
	}

	@Override
	public Quote updateQuote(Quote quote) throws QuoteNotFoundException{
		int qid=quote.getQuoteId();
		Quote q1=quoteRepo.findById(qid).orElse(null);
		q1.setPremiumType(quote.getPremiumType());
		q1.setPremium(quote.getPremium());
		q1.setDwellingCoverage(quote.getDwellingCoverage());
		q1.setDetachedStructureCoverage(quote.getDetachedStructureCoverage());
		q1.setPersonalPropertyCoverage(quote.getPersonalPropertyCoverage());
		q1.setAdditionalLivingExpense(quote.getAdditionalLivingExpense());
		q1.setMedicalExpense(quote.getMedicalExpense());
		q1.setDeductibleAmount(quote.getDeductibleAmount());
		return quoteRepo.save(q1);
	}

	@Override
	public Optional<Quote> findQuoteById(int quoteId) {
		
		return quoteRepo.findById(quoteId);
	}

	@Override
	public void removeQuote(int quoteId) {
		
		quoteRepo.deleteById(quoteId);
	}

	@Override
	public List<Quote> showAllQuotes() {
	   
		return quoteRepo.findAll();
	}

	@Override
	public List<Quote> getAllQuotesByPremiumType(String prumtype) {
		
		return quoteRepo.findByPremiumType(prumtype);
	}

}
