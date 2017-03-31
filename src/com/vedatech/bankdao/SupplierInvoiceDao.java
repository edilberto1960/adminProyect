package com.vedatech.bankdao;

import java.util.List;

import com.vedatech.bank.beans.SupplierInvoice;
import com.vedatech.bank.beans.TransactionsAccounts;


public interface SupplierInvoiceDao {

	public List<SupplierInvoice>findAllInvoice();
	public SupplierInvoice findInvoiceById(Integer id);
	public void saveTransactions(SupplierInvoice invoice);
	public void updateBalance(Double totalPayments, int idInvoice);
}
