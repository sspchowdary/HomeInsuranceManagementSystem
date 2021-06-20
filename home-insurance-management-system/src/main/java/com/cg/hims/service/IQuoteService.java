package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.QuoteNotFoundException;

public interface IQuoteService {
	
	public Quote addQuote(Quote quote);
	
	public Quote updateQuote(Quote quote) throws QuoteNotFoundException;
	
	public Optional<Quote> findQuoteById(int quoteId);
	
	public void removeQuote(int quoteId);
	
	public List<Quote> showAllQuotes();
	
	public List<Quote> getAllQuotesByPremiumType(String prumtype);

}
