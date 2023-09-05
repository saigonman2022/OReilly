package com.oreilly.dto;

public class InvoiceData 
{
	private String time;
	private TenderDetails tenderDetails;
	private String storeNumber;
	
	public String getTime() 
	{
		return time;
	}
	
	public void setTime(String time) 
	{
		this.time = time;
	}
	
	public TenderDetails getTenderDetails() 
	{
		return tenderDetails;
	}
	
	public void setTenderDetails(TenderDetails tenderDetails) 
	{
		this.tenderDetails = tenderDetails;
	}
	
	public String getStoreNumber() 
	{
		return storeNumber;
	}
	
	public void setStoreNumber(String storeNumber) 
	{
		this.storeNumber = storeNumber;
	}
}
