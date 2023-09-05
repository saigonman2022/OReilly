package com.oreilly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers") // If don't specify table name, the default name will be Customer (class name)
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "invoice_id") // If don't specify column name, the default table column name will be "invoiceId"
	private String invoiceId;
	
	@Column(name = "invoice_data")
	private String invoiceData;
	
	public Customer() 
	{
	}
	
	public Customer(final String customerId, final String invoiceId, final String invoiceData) 
	{
		super();
		this.customerId = customerId;
		this.invoiceId = invoiceId;
		this.invoiceData = invoiceData;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getCustomerId() 
	{
		return customerId;
	}

	public void setCustomerId(String customerId) 
	{
		this.customerId = customerId;
	}

	public String getInvoiceId() 
	{
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) 
	{
		this.invoiceId = invoiceId;
	}

	public String getInvoiceData() 
	{
		return invoiceData;
	}

	public void setInvoiceData(String invoiceData) 
	{
		this.invoiceData = invoiceData;
	}
}
