package com.vedatech.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import com.vedatech.bank.beans.Bank;
import com.vedatech.bankservice.BankServiceImpl;


@Controller
public class BankController {
	
	@Autowired
	BankServiceImpl bankService;  //Service which will do all data retrieval/manipulation work
	
	@RequestMapping(value = "/get/bankpage", method = RequestMethod.GET)
	private String BankList(Model model){
		model.addAttribute("resultado", "Resultado desde BankController");
		return "bank/bank_list";
	}
	
	@RequestMapping(value = "/get/test", method = RequestMethod.GET)
	private String BankTest(Model model){
		model.addAttribute("resultado", "Resultado desde BankController TEst");
		return "bank/bank_test";
	}
	
	@RequestMapping(value="/template/city", method =RequestMethod.GET)
	private String BankListDirectives(Model model){
		model.addAttribute("resultado", "Resultado desde BankController");
		return "bank/bank_trasaction";
	}

	 //-------------------Retrieve All Bank Accounts--------------------------------------------------------
    
    @RequestMapping(value = "/get/banklist", method = RequestMethod.GET)
    public ResponseEntity<List<Bank>> listAllBank() {
    	System.out.println("pasamos por bank list");
        List<Bank> bank = bankService.findAllBankAcc();
        if(bank.isEmpty()){
            return new ResponseEntity<List<Bank>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println("Datos de Bank list " + " "+ bank);
        return new ResponseEntity<List<Bank>>(bank, HttpStatus.OK);
    }
    
  //-------------------Create a Bank Account--------------------------------------------------------
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createBankAccount(@RequestBody Bank bank, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + bank.getAccountNumber());
 
        if (bankService.isUserExist(bank)) {
            System.out.println("A Bank Account number " + bank.getAccountNumber() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        bankService.saveBank(bank);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bank/{id}").buildAndExpand(bank.getIdBank()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------------- Update a Bank Account --------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Bank> updateUser(@PathVariable("id") int id, @RequestBody Bank bank) {
        System.out.println("Updating User " + id);
         
        Bank currentBank = bankService.findBankById(id);
         
        if (currentBank==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
        }
 
        currentBank.setNameBank(bank.getNameBank());
        currentBank.setAccountNumber(bank.getAccountNumber());
        currentBank.setInitialDate(bank.getInitialDate());
        currentBank.setInitialBalance(bank.getInitialBalance());
         
        bankService.updateBank(currentBank);
        return new ResponseEntity<Bank>(currentBank, HttpStatus.OK);
    }
    
    //------------------- Delete a Bank Account --------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Bank> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        Bank bank = bankService.findBankById(id);
        if (bank == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
        }
 
        bankService.deleteBank(bank);
        return new ResponseEntity<Bank>(HttpStatus.NO_CONTENT);
    }
  
}
