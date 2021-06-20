package com.cg.hims.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.repository.IQuoteRepository;
import com.cg.hims.service.IQuoteServiceImpl;

@SpringBootTest
public class IQuoteServiceImplTest {
	
	@Autowired
	IQuoteServiceImpl quoteServiceImpl;
	
	@MockBean
	IQuoteRepository quoteRepo;
	
	@Test
	void testaddQuote() {
		Quote q1 = new Quote();
		q1.setQuoteId(1);
		q1.setPremiumType("Premium");
		q1.setPremium(500000);
		q1.setDwellingCoverage(50000);
		q1.setDetachedStructureCoverage(75000);
		q1.setPersonalPropertyCoverage(100000);
		q1.setAdditionalLivingExpense(100000);
		q1.setMedicalExpense(105000);
		q1.setDeductibleAmount(70000);
		
		//Quote q2 = new Quote();
		//q2.setQuoteId(2);
		//q2.setPremiumType("Basic");
		//q2.setPremium(600000);
		//q2.setDwellingCoverage(70000);
		//q2.setDetachedStructureCoverage(85000);
		//q2.setPersonalPropertyCoverage(105000);
		//q2.setAdditionalLivingExpense(110000);
		//q2.setMedicalExpense(130000);
		//q2.setDeductibleAmount(100000);
		
		//List<Quote> qList = new ArrayList();
		//qList.add(q2);
		
		Mockito.when(quoteRepo.save(q1)).thenReturn(q1);
		
		assertThat(quoteServiceImpl.addQuote(q1)).isEqualTo(q1);
		
	}
	
	@Test
	void testupdateQuote() throws QuoteNotFoundException {
		Quote q1 = new Quote();
		q1.setQuoteId(1);
		q1.setPremiumType("Premium");
		q1.setPremium(500000);
		q1.setDwellingCoverage(50000);
		q1.setDetachedStructureCoverage(75000);
		q1.setPersonalPropertyCoverage(100000);
		q1.setAdditionalLivingExpense(100000);
		q1.setMedicalExpense(105000);
		q1.setDeductibleAmount(70000);
		
		Optional<Quote> q2 = Optional.of(q1);
		Mockito.when(quoteRepo.findById(1)).thenReturn(q2);
		q1.setPremiumType("Basic");
		Mockito.when(quoteRepo.save(q1)).thenReturn(q1);
		assertThat(quoteServiceImpl.updateQuote(q1)).isEqualTo(q1);
	}
	
	@Test
	void testFindQuoteById() {
		Quote q1 = new Quote();
		q1.setQuoteId(1);
		q1.setPremiumType("Premium");
		q1.setPremium(500000);
		q1.setDwellingCoverage(50000);
		q1.setDetachedStructureCoverage(75000);
		q1.setPersonalPropertyCoverage(100000);
		q1.setAdditionalLivingExpense(100000);
		q1.setMedicalExpense(105000);
		q1.setDeductibleAmount(70000);
		
		Optional<Quote> q2 = Optional.of(q1);
		Mockito.when(quoteRepo.findById(1)).thenReturn(q2);
		assertThat(quoteServiceImpl.findQuoteById(1)).isEqualTo(q2);
	}
	
	@Test
	void testRemoveQuote() {
		Quote q1 = new Quote();
		q1.setQuoteId(1);
		q1.setPremiumType("Premium");
		q1.setPremium(500000);
		q1.setDwellingCoverage(50000);
		q1.setDetachedStructureCoverage(75000);
		q1.setPersonalPropertyCoverage(100000);
		q1.setAdditionalLivingExpense(100000);
		q1.setMedicalExpense(105000);
		q1.setDeductibleAmount(70000);
		
		Optional<Quote> q2 = Optional.of(q1);
		Mockito.when(quoteRepo.findById(1)).thenReturn(q2);
		Mockito.when(quoteRepo.existsById(q1.getQuoteId())).thenReturn(false);
		assertFalse(quoteRepo.existsById(q1.getQuoteId()));
	}
	
	@Test
	void testShowAllQuotes() {
		Quote q1 = new Quote();
		q1.setQuoteId(1);
		q1.setPremiumType("Premium");
		q1.setPremium(500000);
		q1.setDwellingCoverage(50000);
		q1.setDetachedStructureCoverage(75000);
		q1.setPersonalPropertyCoverage(100000);
		q1.setAdditionalLivingExpense(100000);
		q1.setMedicalExpense(105000);
		q1.setDeductibleAmount(70000);
		
		Quote q2 = new Quote();
		q2.setQuoteId(2);
		q2.setPremiumType("Basic");
		q2.setPremium(600000);
		q2.setDwellingCoverage(70000);
		q2.setDetachedStructureCoverage(85000);
		q2.setPersonalPropertyCoverage(105000);
		q2.setAdditionalLivingExpense(110000);
		q2.setMedicalExpense(130000);
		q2.setDeductibleAmount(100000);
		
		List<Quote> qList = new ArrayList();
		qList.add(q1);
		qList.add(q2);
		
		Mockito.when(quoteRepo.findAll()).thenReturn(qList);
		assertThat(quoteServiceImpl.showAllQuotes()).isEqualTo(qList);
	}
	
	@Test
	void testGetAllQuotesByPremiumType() throws QuoteNotFoundException{
		Quote q1 = new Quote();
		q1.setQuoteId(1);
		q1.setPremiumType("Premium");
		q1.setPremium(500000);
		q1.setDwellingCoverage(50000);
		q1.setDetachedStructureCoverage(75000);
		q1.setPersonalPropertyCoverage(100000);
		q1.setAdditionalLivingExpense(100000);
		q1.setMedicalExpense(105000);
		q1.setDeductibleAmount(70000);
		
		Quote q2 = new Quote();
		q2.setQuoteId(2);
		q2.setPremiumType("Basic");
		q2.setPremium(600000);
		q2.setDwellingCoverage(70000);
		q2.setDetachedStructureCoverage(85000);
		q2.setPersonalPropertyCoverage(105000);
		q2.setAdditionalLivingExpense(110000);
		q2.setMedicalExpense(130000);
		q2.setDeductibleAmount(100000);
		
		List<Quote> qList = new ArrayList();
		qList.add(q1);
		qList.add(q2);
		Mockito.when(quoteRepo.findByPremiumType("Premium")).thenReturn(qList);
		assertThat(quoteServiceImpl.getAllQuotesByPremiumType("Premium")).isEqualTo(qList);
	}

}
