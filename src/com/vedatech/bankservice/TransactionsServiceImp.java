package com.vedatech.bankservice;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vedatech.bank.beans.Bank;
import com.vedatech.bank.beans.SupplierInvoice;
import com.vedatech.bank.beans.TransactionsAccounts;
import com.vedatech.bankdao.AbstractDao;
import com.vedatech.bankdao.TransactionsDao;


@Service("transService")
public class TransactionsServiceImp extends AbstractDao<Integer, TransactionsAccounts> implements TransactionsService{
	
	@Resource(name="transDao")
	private TransactionsDao transDao;

	@Override
	public Bank findBankById(Integer id) {
		return transDao.findBankById(id);
	}
	
	@Override
	public TransactionsAccounts findTransactionsById(Integer id){
		return transDao.findTransactionsById(id);
	}


	@Override
	public List<TransactionsAccounts> getTransactionByAcc(int idBank) {
		// TODO Auto-generated method stub
		return transDao.getTransactionByAcc(idBank);
	}
	
	public List<TransactionsAccounts> getTransactionByAcc(int idBank, String stDate, String edDate) throws ParseException{
		return transDao.getTransactionByAcc(idBank, stDate, edDate);
	}
	
	public void saveTransactions(TransactionsAccounts transactions, int id){
		System.out.println("Bank Id "+transactions.getBank().getIdBank());
		//getBalanceById(transactions.getBank().getIdBank());
		//double balance = 0;
		//double newBalance=0;
		//double balance =getBalanceByIdBank(transactions.getBank().getIdBank());
		//double newBalance = balance + transactions.getTransactionDepositAmount()-transactions.getTransactionAmount();
		//System.out.println("New Balance "+newBalance);
	//	TransactionsAccounts transactionsCall = new TransactionsAccounts();
	//	transactionsCall.set
		
	//	transactions.setTransactionsBalance(newBalance);
		
		
		
		transDao.saveTransactionsToPayInvoice(transactions,id);
	}
	
	public void updateTransactions(TransactionsAccounts transactions){
		transDao.updateTransactions(transactions);
	}
	
	public List<TransactionsAccounts> getBalanceById(Integer idBank){
		return transDao.getBalanceById(idBank);
	}
	public Double getBalanceByIdBank(Integer idBank){
		
		return transDao.getBalanceByIdBank(idBank);
	}
	
	public void deleteTransaction(TransactionsAccounts transaction){
		transDao.deleteTransaction(transaction);
	}

	@Override
	public void saveTransactions(TransactionsAccounts transactions) {
		transDao.saveTransactions(transactions);
		
	}

	@Override
	public void saveTransactionsToPayInvoice(TransactionsAccounts transaction, int id) {
	
		
		transDao.saveTransactionsToPayInvoice(transaction, id);
		
	}

	@Override
	public List getSumPaymentIdInvoice( int id) {
	 return	transDao.getSumPaymentIdInvoice(id);
	
	}
	
}
