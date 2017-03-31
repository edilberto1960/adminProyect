package com.vedatech.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "INVOICE")
public class SupplierInvoice {
	
	@Id
	@GeneratedValue
	@Column(name = "IDINVOICE")
	private int idInvoice;
	
	@Column(name="DATE")
	private Date transactionsDate;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	@Column(name="TOTAL")
	private double supplierTotal;
	
	@Column(name="BALANCE")
	private double balance;
	
/*	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="TRANSACTIONS_INVOICE", joinColumns=@JoinColumn(name="INVOICE_IDINVOICE"), 
		inverseJoinColumns=@JoinColumn(name="TRANSACTIONS_IDTRANSACTIONS"))
	private List<TransactionsAccounts> transactions = new ArrayList<>();*/

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(int idInvoice) {
		this.idInvoice = idInvoice;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public Date getTransactionsDate() {
		return transactionsDate;
	}

	public void setTransactionsDate(Date transactionsDate) {
		this.transactionsDate = transactionsDate;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public double getSupplierTotal() {
		return supplierTotal;
	}

	public void setSupplierTotal(double supplierTotal) {
		this.supplierTotal = supplierTotal;
	}

	/*public List<TransactionsAccounts> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionsAccounts> transactions) {
		this.transactions = transactions;
	}*/
	
	

}
