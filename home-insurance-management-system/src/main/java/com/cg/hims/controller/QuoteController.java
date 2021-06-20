package com.cg.hims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.service.IQuoteServiceImpl;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path= "/api")
public class QuoteController {
	
	@Autowired
	private IQuoteServiceImpl quoteServiceImpl;
	
	@RequestMapping(value= "/quote/add", method= RequestMethod.POST)
	public Quote addQuote(@Valid @RequestBody Quote newquote) {
		return quoteServiceImpl.addQuote(newquote);
	}
	
	@RequestMapping(value= "/quote/update/{id}", method= RequestMethod.PUT)
	public Quote updateQuote(@Valid @RequestBody Quote updquote, @PathVariable int id) throws QuoteNotFoundException {
		Quote q1=quoteServiceImpl.updateQuote(updquote);
		return q1;
		
	}
	
	@RequestMapping(value= "/quote/{id}", method = RequestMethod.GET)
	public Quote getQuote(@PathVariable int id) throws QuoteNotFoundException {
		Optional<Quote> quote = quoteServiceImpl.findQuoteById(id);
		if(!quote.isPresent()) {
			throw new QuoteNotFoundException("quote not found for this id "+id);
		}
		else
			return quote.get();
	}
	
	@RequestMapping(value= "/quote/delete/{id}", method= RequestMethod.DELETE)
	public void deleteQuote(@PathVariable int id) throws QuoteNotFoundException {
		Optional<Quote> qut = quoteServiceImpl.findQuoteById(id);
		if(!qut.isPresent()) {
			throw new QuoteNotFoundException("quote not found for this id "+id);
		}
		else {
			quoteServiceImpl.removeQuote(id);
		}
	}
	
	@RequestMapping(value= "/allquote", method= RequestMethod.GET)
	public List<Quote> showAllQuotes() {
		return quoteServiceImpl.showAllQuotes();
	}
	
	@RequestMapping(value="/quote/all/bypremiumtype/{prumtype}", method= RequestMethod.GET)
	public List<Quote> getAllQuotesByPremiumType(@PathVariable(value= "prumtype") String prumtype) throws QuoteNotFoundException {
		List<Quote> Quotes = quoteServiceImpl.getAllQuotesByPremiumType(prumtype);
		if(Quotes.isEmpty()) {
			throw new QuoteNotFoundException("Could not find quote this premiumtype-" +prumtype);
		}
		else {
			return quoteServiceImpl.getAllQuotesByPremiumType(prumtype);
		}
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
     
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
         
        return errors;
    }
}
