package com.vedatech.bank.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;


@Entity
@Table(name = "TRANSACTIONS")
public class TransactionsAccounts {
	
	@Id
	@Column(name = "IDTRANSACTIONS")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTransactions;
	
	@Column(name="TRANSACTIONS_DATE")
	private Date transactionsDate;
	
	@Column(name="TRANSACTIONS_DATE_OPERATIONS")
	private Date transactionsDateOperation;
	
	@Column(name="TRANSACTIONS_TYPE")
	private String trasactionType;
	
	@Column(name="TRANSACTIONS_NUMBER")
	private int transactionNum;
	
	@Column(name="TRANSACTIONS_ORDER_TO")
	private String transactionOrderTo;
	
	@Column(name="TRANSACTIONS_SPEND")
	private Double transactionAmount;
	
	@Column(name="TRANSACTIONS_DEPOSIT_AMOUNT")
	private Double transactionDepositAmount;
	
	@Transient
	private Double balance;
	
	@Column(name="TRANSACTIONS_DESCRIPTION_DETAILS")
	private String transactionsDescriptionDetails;
	
	@ManyToOne
	@JoinColumn(name="BANKS_ACCOUNTS_IDBANK")
	private Bank bank;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
	@JoinTable(name="TRANSACTIONS_INVOICE", joinColumns = @JoinColumn(name="TRANSACTIONS_IDTRANSACTIONS"), 
		inverseJoinColumns=@JoinColumn(name="INVOICE_IDINVOICE"))
	private SupplierInvoice supplierInvoice;
	
	

	public int getIdTransactions() {
		return idTransactions;
	}

	public void setIdTransactions(int idTransactions) {
		this.idTransactions = idTransactions;
	}

	public Date getTransactionsDate() {
		return transactionsDate;
	}

	public void setTransactionsDate(Date transactionsDate) {
		this.transactionsDate = transactionsDate;
	}

	public Date getTransactionsDateOperation() {
		return transactionsDateOperation;
	}

	public void setTransactionsDateOperation(Date transactionsDateOperation) {
		this.transactionsDateOperation = transactionsDateOperation;
	}

	public String getTrasactionType() {
		return trasactionType;
	}
		
	public int getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(int transactionNum) {
		this.transactionNum = transactionNum;
	}

	public void setTrasactionType(String trasactionType) {
		this.trasactionType = trasactionType;
	}

	public String getTransactionOrderTo() {
		return transactionOrderTo;
	}

	public void setTransactionOrderTo(String transactionOrderTo) {
		this.transactionOrderTo = transactionOrderTo;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionsDescriptionDetails() {
		return transactionsDescriptionDetails;
	}

	public void setTransactionsDescriptionDetails(
			String transactionsDescriptionDetails) {
		this.transactionsDescriptionDetails = transactionsDescriptionDetails;
	}
	
	public Double getTransactionDepositAmount() {
		return transactionDepositAmount;
	}

	public void setTransactionDepositAmount(Double transactionDepositAmount) {
		this.transactionDepositAmount = transactionDepositAmount;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public SupplierInvoice getSupplierInvoice() {
		return supplierInvoice;
	}

	public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
		this.supplierInvoice = supplierInvoice;
	}
	
	
}
