package com.oreilly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oreilly.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	//JPQL
    @Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
	List<Customer> getCustomerInfoByCustomerId(final String customerId);
}
