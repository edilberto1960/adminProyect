package com.vedatech.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.vedatech.bank.beans.TransactionsAccounts;
import com.vedatech.bankservice.TransactionsService;

public abstract class AbstractTransactionController {
	
	@Autowired
	TransactionsService transService;
	
	public  List<TransactionsAccounts>getAllTransactions(TransactionsAccounts transaction) throws ParseException{
		System.out.println("Valor de id "+ transaction.getBank().getNameBank()); 
		
		List<TransactionsAccounts> transactions=transService.getTransactionByAcc(transaction.getBank().getIdBank());
		return transactions;

}
	
}
