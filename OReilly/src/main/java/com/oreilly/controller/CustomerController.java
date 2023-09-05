package com.oreilly.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oreilly.converter.CustomerResponseDtoConverter;
import com.oreilly.dto.CustomerInfoResponseDto;
import com.oreilly.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerResponseDtoConverter converter;
	
	/*
	 * This endpoint will return the response specified in the test requirement
	 * Example of the response
	 * {
    	"55": "cash",
    	"56": "credit"
		}
	 */
	@GetMapping("v1/customers/{customerId}")
	public Map<Long, String> getCustomerInfo(@PathVariable final long customerId) throws Exception
	{
		try 
		{
			Map<Long, String> response = this.customerService.getCustomerInfoByCustomerId(customerId);
			return response;
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}		
	}
	
	/*
	 * This endpoint will return the same data as in v1 version but with enhancement for
	 * more readability
	 * Example of the response:
	 * 	[
    		{
        		"invoiceId": 55,
        		"tenderType": "cash"
    		},
    		{
        		"invoiceId": 56,
        		"tenderType": "credit"
    		}
		]
	 */
	@GetMapping("v2/customers/{customerId}")
	public List<CustomerInfoResponseDto> getCustomerInfoV2(@PathVariable final long customerId) throws Exception
	{
		try 
		{
			Map<Long, String> response = this.customerService.getCustomerInfoByCustomerId(customerId);
			return converter.toDto(response);
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}		
	}
}
