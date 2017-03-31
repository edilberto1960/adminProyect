package com.vedatech.bankdao;

import java.util.List;

import com.vedatech.bank.beans.Bank;


public interface BankAccountDao {
	
	public List<Bank>findAllBankAcc();

	void saveBank(Bank bank);
	
	public void deleteBank(Bank bank);
	
	public void updateBank(Bank bank);
	
	Bank findByName(String name);
	
	public boolean isUserExist(Bank bank);

	Bank findBankById(int id);

}
