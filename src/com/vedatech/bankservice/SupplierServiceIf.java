package com.vedatech.bankservice;

import java.util.List;


import com.vedatech.bank.beans.SupplierInvoice;
import com.vedatech.bank.beans.TransactionsAccounts;

public interface SupplierServiceIf {
	
	public List<SupplierInvoice>findAllSupplierInvoice();
	public SupplierInvoice findInvoiceById(Integer id);
	public void saveTransactions(SupplierInvoice invoice);
	void updateBalance(Double totalPayments, int idInvoice);


}
