package com.vedatech.bankdao;

import java.text.ParseException;
import java.util.List;

import com.vedatech.bank.beans.Bank;
import com.vedatech.bank.beans.TransactionsAccounts;

public interface TransactionsDao {
	
	public Bank findBankById(Integer id);
	public List<TransactionsAccounts> getTransactionByAcc(int idCheck);
	public List<TransactionsAccounts> getTransactionByAcc(int idBank, String stDate, String edDate) throws ParseException;
	void saveTransactions(TransactionsAccounts transactions);
	public List<TransactionsAccounts> getBalanceById(Integer idBank);
	public Double getBalanceByIdBank(Integer idBank);
	public TransactionsAccounts findTransactionsById(Integer id);
	public void updateTransactions(TransactionsAccounts transactions);
	public void deleteTransaction(TransactionsAccounts transaction);
	void saveTransactionsToPayInvoice(TransactionsAccounts transactions, int id);
	public List getSumPaymentIdInvoice(int id);
	


}
