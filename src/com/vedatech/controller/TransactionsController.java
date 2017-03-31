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
import com.vedatech.bankservice.TransactionsService;


@Controller
public class TransactionsController extends AbstractTransactionController{
	
	@Resource(name="transService")
	TransactionsService transService;
	
	@Resource(name="supplierService")
	SupplierServiceIf supplierService;
	
	//
	
	@RequestMapping(value="/get/transactions", method = RequestMethod.GET)
	public String GetTransactions(){
		
		return "bank/bank_transaction";
	}
	
	@RequestMapping(value="/get/transactionsby/{id}", method = RequestMethod.POST)
		public ResponseEntity<List<TransactionsAccounts>> getCheckTransactions(@PathVariable("id") int idBank) throws ParseException{
		System.out.println("Valor de id "+ idBank); 
		List<TransactionsAccounts> transactions=transService.getTransactionByAcc(idBank);
		return new ResponseEntity<List<TransactionsAccounts>>(transactions, HttpStatus.OK);
	}
	

		//-------------------Create a new Transaction bank--------------------------------------------------------
	    
	@RequestMapping(value = "/save/transaction/", method = RequestMethod.POST)
	    public ResponseEntity<List<TransactionsAccounts>> createBankAccount( @RequestBody TransactionsAccounts transaction) throws Exception {
	    	
		System.out.println("RECIBIMOS LA TRANSACTION PARA GRABAR " + transaction);
		
		   transService.saveTransactions(transaction);
	    
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
			 return new ResponseEntity<List<TransactionsAccounts>>(getAllTransactions(transaction), HttpStatus.OK);
	    }
	
	//-------------------Create a new Transaction To Pay Invoice--------------------------------------------------------
    
	@RequestMapping(value = "/save/transactiontopay/{id}", method = RequestMethod.POST)
	    public ResponseEntity<List<TransactionsAccounts>> createTransactionToPay(@PathVariable("id") int id, @RequestBody TransactionsAccounts transaction) throws Exception {
	    	
		System.out.println("RECIBIMOS LA TRANSACTION PARA GRABAR " + transaction);
	     System.out.println("PAGANDO LA FACTURA CON ID " + id);  
	     
	     transService.saveTransactionsToPayInvoice(transaction, id);
	     
	     //Verificar si ya hemos hecho algunas aportaciones a la factura idInvoice, traer la suma de estas si es true
	     List totalPayments = transService.getSumPaymentIdInvoice(id);
	     System.out.println("Total de la Suma de Pagos" +totalPayments.get(0));
	     
	     
	     
	     
	     // Vamos actualizar el balance en idInvoice SupplierService
	     supplierService.updateBalance((Double)totalPayments.get(0), id);
	     
	    				
			
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
			 return new ResponseEntity<List<TransactionsAccounts>>(getAllTransactions(transaction), HttpStatus.OK);
	    }
	    
	    
	   		
	  //------------------- Update a Transaction --------------------------------------------------------
	    
	    @RequestMapping(value = "/updatetransaction/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<List<TransactionsAccounts>> updateTransaction(@PathVariable("id") int id, @RequestBody TransactionsAccounts transaction) throws ParseException {
	        System.out.println("Updating Transaction " + transaction);
	         System.out.println("Transaction num"+ transaction.getTransactionNum());
	         System.out.println("Tranasaction Deposit " + transaction.getTransactionsDescriptionDetails());
	         System.out.println("Transaction Bank name "+ transaction.getBank().getNameBank());
	        TransactionsAccounts currentTransaction = transService.findTransactionsById(id);
	         
	        if (currentTransaction==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<List<TransactionsAccounts>>(HttpStatus.NOT_FOUND);
	        }
	        currentTransaction.setBank(transaction.getBank());
	        currentTransaction.setTransactionsDate(transaction.getTransactionsDate());
	        currentTransaction.setTransactionsDateOperation(transaction.getTransactionsDateOperation());
	        currentTransaction.setTransactionNum(transaction.getTransactionNum());
	        currentTransaction.setTransactionOrderTo(transaction.getTransactionOrderTo());
	        currentTransaction.setTransactionDepositAmount(transaction.getTransactionDepositAmount());
	        currentTransaction.setTransactionAmount(transaction.getTransactionAmount());
	        currentTransaction.setTransactionsDescriptionDetails(transaction.getTransactionsDescriptionDetails());
	        currentTransaction.setTrasactionType(transaction.getTrasactionType());
	        currentTransaction.setIdTransactions(transaction.getIdTransactions());
	      //  transService.updateTransactions(currentTransaction);
	        
	        
	        try {
		    	   if(currentTransaction.getSupplierInvoice().getIdInvoice() > 0){
			        	System.out.println("ESTA TRANSACTION SI ESTA LIGADA A UNA INVOICE "+ transaction.getSupplierInvoice().getIdInvoice());
			        	int idInvoice = currentTransaction.getSupplierInvoice().getIdInvoice();
			        	
			        	  transService.updateTransactions(currentTransaction);
			   	       
			   	         List totalPayments = transService.getSumPaymentIdInvoice(idInvoice);
			   		     System.out.println("Total de la Suma de Pagos" +totalPayments.get(0));
			   		      
			   		     // Vamos actualizar el balance en idInvoice SupplierService
			   		     
			   		     try {
			   		    	supplierService.updateBalance((Double)totalPayments.get(0), idInvoice);
						} catch (Exception e) {
							supplierService.updateBalance(0.00, idInvoice);// hemos eliminado el ultimo de las aportaciones ala idInvoice
						}
			        }
			} catch (Exception e) {
				System.out.println("ESTA TRANSACTION NO ESTA LIGADA A UNA INVOICE");
				 transService.updateTransactions(currentTransaction);
				
				}
		        
	        
	       
	    	 return new ResponseEntity<List<TransactionsAccounts>>(getAllTransactions(currentTransaction), HttpStatus.OK);
	       
	    }
	    
	    //------------------- Delete a Transaction --------------------------------------------------------
	    
	    @RequestMapping(value = "/deletetransaction/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<List<TransactionsAccounts>> deleteUser(@PathVariable("id") int id) throws ParseException {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        TransactionsAccounts transaction = transService.findTransactionsById(id);
	        /*if (bank == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
	        }*/
	        
	       try {
	    	   if(transaction.getSupplierInvoice().getIdInvoice() > 0){
		        	System.out.println("ESTA TRANSACTION SI ESTA LIGADA A UNA INVOICE "+ transaction.getSupplierInvoice().getIdInvoice());
		        	int idInvoice = transaction.getSupplierInvoice().getIdInvoice();
		        	
		        	  transService.deleteTransaction(transaction);
		   	       
		   	         List totalPayments = transService.getSumPaymentIdInvoice(idInvoice);
		   		     System.out.println("Total de la Suma de Pagos" +totalPayments.get(0));
		   		      
		   		     // Vamos actualizar el balance en idInvoice SupplierService
		   		     
		   		     try {
		   		    	supplierService.updateBalance((Double)totalPayments.get(0), idInvoice);
					} catch (Exception e) {
						supplierService.updateBalance(0.00, idInvoice);// hemos eliminado el ultimo de las aportaciones ala idInvoice
					}
		        }
		} catch (Exception e) {
			System.out.println("ESTA TRANSACTION NO ESTA LIGADA A UNA INVOICE");
			 transService.deleteTransaction(transaction);
			
			}
	        
	
	     
		     
	       
	       // List<TransactionsAccounts> alltransactions=transService.getTransactionByAcc(transaction.getBank().getIdBank());
		   	 return new ResponseEntity<List<TransactionsAccounts>>(getAllTransactions(transaction), HttpStatus.OK);
	    }
	    

}
