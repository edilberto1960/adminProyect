package com.vedatech.bankservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.vedatech.bank.beans.SupplierInvoice;
import com.vedatech.bank.beans.TransactionsAccounts;
import com.vedatech.bankdao.SupplierInvoiceDao;


@Service("supplierService")
public class SupplierInvoiceImp implements SupplierServiceIf{
	
	@Resource(name="supplierDao")
	private SupplierInvoiceDao supplierDao;

	@Override
	public List<SupplierInvoice> findAllSupplierInvoice() {
		// TODO Auto-generated method stub
		return supplierDao.findAllInvoice();
	}

	@Override
	public SupplierInvoice findInvoiceById(Integer id) {
		// TODO Auto-generated method stub
		return supplierDao.findInvoiceById(id);
	}

	@Override
	public void saveTransactions(SupplierInvoice invoice) {
		supplierDao.saveTransactions(invoice);
	}

	@Override
	public void updateBalance(Double totalPayments, int idInvoice) {
		supplierDao.updateBalance(totalPayments, idInvoice);
		
	}

	
}
