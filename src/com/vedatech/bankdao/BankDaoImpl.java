package com.vedatech.bankdao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.vedatech.bank.beans.Bank;


@Service("bankDao")
@Transactional
public class BankDaoImpl extends AbstractDao<Integer, Bank> implements BankAccountDao{

	@Override
	public List<Bank> findAllBankAcc() {
		Criteria criteria = createEntityCriteria();
		return (List<Bank>) criteria.list();
	}
	
	@Override
	public void saveBank(Bank bank) {
		persist(bank);
		
	}

	@Override
	public boolean isUserExist(Bank bank) {
		
		return false;
	}

	@Override
	public Bank findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateBank(Bank bank) {
		Session session = getSession();
		session.update(bank);
		
	}

	@Override
	public Bank findBankById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void deleteBank(Bank bank) {
		delete(bank);
		
	}


}
