package com.vedatech.bankservice;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.vedatech.bank.beans.Bank;
import com.vedatech.bankdao.BankAccountDao;

@Service("bankService")
public class BankServiceImpl implements BankAccountsService{
	
	@Resource(name="bankDao")
	private BankAccountDao bankDao;

	@Override
	public List<Bank> findAllBankAcc() {
		// TODO Auto-generated method stub
		return bankDao.findAllBankAcc();
	}

	@Override
	public void saveBank(Bank bank) {
		bankDao.saveBank(bank);
		
	}

	@Override
	public Bank findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserExist(Bank bank) {
		bankDao.isUserExist(bank);
		return false;
	}

	@Override
	public Bank findBankById(int id) {
		// TODO Auto-generated method stub
		return bankDao.findBankById(id);
	}

	@Override
	public void updateBank(Bank bank) {
	 bankDao.updateBank(bank);
		
	}

	@Override
	public void deleteBank(Bank bank) {
		bankDao.deleteBank(bank);
		
	}

}
