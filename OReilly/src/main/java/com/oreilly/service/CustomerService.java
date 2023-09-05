package com.oreilly.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.oreilly.dto.InvoiceData;
import com.oreilly.model.Customer;
import com.oreilly.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	public Map<Long, String> getCustomerInfoByCustomerId(final long customerId) throws Exception
	{
		List<Customer>customers = customerRepository.getCustomerInfoByCustomerId(Long.toString(customerId));
		return getCustomerInfo(customers);
	}
	
	// This method assume the value of the InvoiceData column in the database is valid json string
	private Map<Long, String> getCustomerInfo(final List<Customer> customers)
	{
		Map<Long, String> result = new HashMap<>();
		
		for (Customer customer: customers)
		{
			Long invoiceId = Long.parseLong(customer.getInvoiceId());
			String invoiceData = customer.getInvoiceData();
			
			// valid invoicedata json format
			String tenderType = gettenderType_ValidJsonFormat(invoiceData);
			
//			// invalid invoicedata json format
//			String tenderType = gettenderType_InvalidJsonFormat(invoiceData);
			
			result.put(invoiceId, tenderType);
		}
		
		return result;
	}
	
	// This method assume the value of the InvoiceData column in the database is not valid json string
	// i.e the values specified in the test pdf file
	private String gettenderType_ValidJsonFormat(final String invoiceData)
	{
		Gson gson = new Gson();
		InvoiceData invoice = gson.fromJson(invoiceData, InvoiceData.class);
			
		String tenderType = invoice.getTenderDetails().getType();
		return tenderType;
	}
	
	private String gettenderType_InvalidJsonFormat(final String invoiceData)
	{
		String newInvoiceData = invoiceData.replace("{", "@");
		newInvoiceData = newInvoiceData.replace("}", "@");
		
		String[] results = newInvoiceData.split("@");
		String tenderDetails = results[2]; // get the value of the tenderDetails block
		// Assume that the format of the tender detail value will always be like
		// amount:value, type:value.
		// Otherwise, there will be different string scan to find the value of the tenderDetail type
		String[] tenderDetailsData = tenderDetails.split(":");
		// last value in the array is the value of the type
		if (tenderDetailsData.length != 3)
		{
			throw new IllegalArgumentException("Invalid InvoiceData value format."); 
		}
		String value = tenderDetailsData[2];
		return value.substring(2, value.length() - 1);
	}
}
