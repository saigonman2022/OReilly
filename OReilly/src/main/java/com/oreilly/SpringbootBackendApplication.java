package com.oreilly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oreilly.model.Customer;
import com.oreilly.repository.CustomerRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner
{
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception
	{
		//These records contains valid InvoiceData json format
		this.customerRepository.save(new Customer("1", "54", "{\"time\": \"19:53\", \"tenderDetails\": {\"amount\": 23.43, \"type\": \"cash\"}, \"storeNumber\":\"999\"}"));
		this.customerRepository.save(new Customer("2", "55", "{\"time\": \"12:00\", \"tenderDetails\": {\"amount\": 4.95, \"type\": \"cash\"}, \"storeNumber\":\"999\"}"));
		this.customerRepository.save(new Customer("2", "56", "{\"time\": \"08:49\", \"tenderDetails\": {\"amount\": 100.12, \"type\": \"credit\"}, \"storeNumber\":\"999\"}"));
		
		//These records contains invalid InvoiceData json format (values from the pdf test file)
//		this.customerRepository.save(new Customer("1", "54", "{\"time\": 19:53, \"tenderDetails\": {\"amount\": 23.43, \"type\": \"cash\"}, storeNumber:\"999\"}"));
//		this.customerRepository.save(new Customer("2", "55", "{\"time\": 12:00, \"tenderDetails\": {\"amount\": 4.95, \"type\": \"cash\"}, storeNumber:\"999\"}"));
//		this.customerRepository.save(new Customer("2", "56", "{\"time\": 08:49, \"tenderDetails\": {\"amount\": 100.12, \"type\": \"credit\"}, storeNumber:\"999\"}"));
	}

}
