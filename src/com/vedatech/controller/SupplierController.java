package com.vedatech.controller;

import java.text.ParseException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.vedatech.bank.beans.SupplierInvoice;
import com.vedatech.bank.beans.TransactionsAccounts;
import com.vedatech.bankservice.SupplierServiceIf;

@Controller
public class SupplierController extends AbstractSupplierController{
	
	@Resource(name="supplierService")
	SupplierServiceIf supplierService;
	
	
	@RequestMapping(value="/get/supplier", method = RequestMethod.GET)
	public String GetTransactions(){
		
		return "supplier/supplier_invoice";
	}
	
	@RequestMapping(value="/get/allsupplierinvoice/", method = RequestMethod.GET)
	public ResponseEntity<List<SupplierInvoice>> getCheckTransactions()throws ParseException{
	//System.out.println("Valor de id "+ idBank); 
	List<SupplierInvoice> transactions=supplierService.findAllSupplierInvoice();
	for(SupplierInvoice supplier:transactions){
		System.out.println("Supplier Invoice List:" + supplier.getSupplierName());
	}
	
	return new ResponseEntity<List<SupplierInvoice>>(transactions, HttpStatus.OK);
}
	
	//-------------------Create a new Invoice -------------------------------------------------------
    
	@RequestMapping(value = "/save/invoice/", method = RequestMethod.POST)
	    public ResponseEntity<List<SupplierInvoice>> createBankAccount(@RequestBody SupplierInvoice invoice) throws Exception {
	    	
		System.out.println("RECIBIMOS LA TRANSACTION PARA GRABAR " + invoice);
		
		   supplierService.saveTransactions(invoice);
	    
	       /* if (bankService.isUserExist(bank)) {
	            System.out.println("A Bank Account number " + bank.getAccountNumber() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }*/
			
			/*List<TransactionsAccounts> allTransaction=transService.getTransactionByAcc(transactions.getBank().getIdBank()); 
			for(TransactionsAccounts transaction: allTransaction){
				System.out.println("Transaction is " + transaction.getTransactionNum());
			}*/
				/*  HttpHeaders headers = new HttpHeaders();*/
				/* headers.setLocation(ucBuilder.path("/get/transactionsby/{id}").buildAndExpand(transactions.getBank().getIdBank()).toUri());*/
			 return new ResponseEntity<List<SupplierInvoice>>(getAllTransactions(invoice), HttpStatus.OK);
	    }


}
