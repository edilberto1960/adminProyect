package com.vedatech.bankservice;

import java.util.List;

import com.vedatech.bank.beans.Bank;

public interface BankAccountsService {

	public List<Bank>findAllBankAcc();
	
	void saveBank(Bank bank);
	
	public void updateBank(Bank bank);
	
	public void deleteBank(Bank bank);
	
	Bank findByName(String name);
	
	public boolean isUserExist(Bank bank);
	
	Bank findBankById(int id);
}
