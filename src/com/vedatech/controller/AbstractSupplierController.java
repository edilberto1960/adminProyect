package com.vedatech.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vedatech.bank.beans.SupplierInvoice;
import com.vedatech.bankservice.SupplierServiceIf;

public abstract class AbstractSupplierController {
	
	@Autowired
	SupplierServiceIf supplierService;
	
	public  List<SupplierInvoice>getAllTransactions(SupplierInvoice transaction) throws ParseException{
		//System.out.println("Valor de id "+ transaction.getBank().getNameBank()); 
		
		List<SupplierInvoice> transactions=supplierService.findAllSupplierInvoice();
		return transactions;

}

}
