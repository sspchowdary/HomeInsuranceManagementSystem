package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hims.entities.Property;

@Repository


public interface IPropertyRepository extends JpaRepository<Property, Integer> {

}