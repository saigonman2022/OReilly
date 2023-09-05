package com.oreilly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerInfoResponseDto implements Dto
{
	@JsonProperty
	private long invoiceId;
	
	@JsonProperty
	private String tenderType;

	public long getInvoiceId() 
	{
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) 
	{
		this.invoiceId = invoiceId;
	}

	public String getTenderType() 
	{
		return tenderType;
	}

	public void setTenderType(String tenderType) 
	{
		this.tenderType = tenderType;
	}
}
