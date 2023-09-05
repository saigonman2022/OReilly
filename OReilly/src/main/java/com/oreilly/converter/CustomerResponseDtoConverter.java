package com.oreilly.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.oreilly.dto.CustomerInfoResponseDto;

@Component
public class CustomerResponseDtoConverter 
{
	public List<CustomerInfoResponseDto> toDto(final Map<Long, String> objects)
	{
		List<CustomerInfoResponseDto> results = new ArrayList<>();
		
		objects.forEach((k, v) -> results.add(createCustomerInfoResponseDto(k, v)));
		return results;
	}
	
	private CustomerInfoResponseDto createCustomerInfoResponseDto(Long k, String v)
	{
		CustomerInfoResponseDto dto = new CustomerInfoResponseDto();
		dto.setInvoiceId(k);
		dto.setTenderType(v);
		return dto;
	}
}
