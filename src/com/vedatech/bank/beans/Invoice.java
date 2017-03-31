package com.vedatech.bank.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//
@Entity
@Table(name = "INVOICES")
public class Invoice {
	
	@Id
	@Column(name = "IDINVOICE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTransactions;
	
	@Column(name="INVOICE_DATE")
	private Date transactionsDate;
	
	@Column(name="INVOICE_DESCRIPTION")
	private String trasactionType;
	
	@Column(name="INVOICE_NUMBER")
	private int transactionNum;
	
	@Column(name="INVOICE_ORDER_TO")
	private String transactionOrderTo;
	
	@Column(name="INVOICE_SUBTOTAL")
	private Double transactionDepositAmount;
	
	@Column(name="INOVICE_DESCRIPTION_DETAILS")
	private String transactionsDescriptionDetails;

}
