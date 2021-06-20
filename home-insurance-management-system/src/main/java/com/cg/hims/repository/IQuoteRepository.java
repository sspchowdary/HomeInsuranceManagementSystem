package com.cg.hims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hims.entities.Quote;

@Repository
public interface IQuoteRepository extends JpaRepository<Quote, Integer> {
	
	List<Quote> findByPremiumType(String premiumtype);

}
