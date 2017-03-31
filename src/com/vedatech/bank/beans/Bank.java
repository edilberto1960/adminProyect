package com.vedatech.bank.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//111

@Entity
@Table(name = "BANKS_ACCOUNTS")
public class Bank {
	
	@Id
	@Column(name = "IDBANK")
	@GeneratedValue
	private int idBank;
	
	@Column(name = "INITIAL_DATE")
	private Date initialDate;
	
	@Column(name = "BANK_NAME")
	private String nameBank;
	
	@Column(name = "BANK_ACCOUNT_NUMBER")
	private int accountNumber;
	
	@Column(name = "INITIAL_BALANCE")
	private double initialBalance;
	
	
	public int getIdBank() {
		return idBank;
	}
	public void setIdBank(int idBank) {
		this.idBank = idBank;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public String getNameBank() {
		return nameBank;
	}
	public void setNameBank(String nameBank) {
		this.nameBank = nameBank;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	
	
	

}
