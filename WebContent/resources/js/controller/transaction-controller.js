'use strict'
angular.module('weatherApp').controller('TransController', ['$scope','$routeParams', 'serviceTransaction','UserService', 'serviceSupplier', function($scope,$routeParams, serviceTransaction,UserService,serviceSupplier) {
	
		var self = this;
	
		self.transaction={
			bank:{idBank:null, nameBank:'', initialDate:'', accountNumber:'', initialBalance:''},
			idTransactions:null,
			transactionsDate:'',
			transactionsDateOperation:'',
			trasactionType:'Check in',
			transactionNum:'',
			transactionOrderTo:'',
			transactionAmount:null,
			transactionDepositAmount:'',
			balance:'',
			transactionsDescriptionDetails:''	
		};
		
		$scope.reset ='';
		self.invoiceToPayId = null;
		self.transaction.bank.idBank = $routeParams.idBank;
		$scope.id = $routeParams.idBank;
		
		self.alltransaction=[];
		$scope.bankOptions={idBank:'1', nameBank:'Banorte'};
		
		$scope.dataType = 
		     [
		      'Check in',
		       'other to Deposit',
		       'Payment To Supplier Invoice',
		       'Deposit from Clients Invoice'
		    ];
		$scope.checked = 'cat';
		
		
		
		$scope.dataBanks = {
				bankOptions:[]
				};
		
		self.dataPayment=[];
		
		
		 self.roles = [
			    {id: 1, text: 'guest'},
			    {id: 2, text: 'user'},
			    {id: 3, text: 'customer'},
			    {id: 4, text: 'admin'}
			  ];
		 
		 $scope.user = {
				    roles: [self.roles[1]],
				   
				    
				  };
		
		self.invoiceToPay=[];
		
		$scope.bankSelected ={idBank:$routeParams.idBank, nameBank:'Banorte'}		
		
		$scope.data = {
			    availableOptions: [
			      {id: '1', name: 'Check'},
			      {id: '2', name: 'other Deposit'},
			      {id: '3', name: 'Pay To Supplier Invoice'},
			      {id: '4', name: 'Deposit from Clients Invoice'}
			    ],
			    selectedOption: {id: '4', name: 'Select the Options'} //This sets the default value of the select in the ui
			    };
		
		$scope.checkboxModel = {
			       value:[]
			     };
		$scope.checkboxModelOne='';
		
		$scope.items = [1,2,3,4];
		  $scope.selected = [1];
		  $scope.list=[];
		 /* $scope.toggle = function (item, list) {
		    var idx = list.indexOf(item);
		    if (idx > -1) {
		      list.splice(idx, 1);
		    }
		    else {
		      list.push(item);
		    }
		  };

		  $scope.exists = function (item, list) {
		    return list.indexOf(item) > -1;
		  };

		  $scope.isIndeterminate = function() {
		    return ($scope.selected.length !== 0 &&
		        $scope.selected.length !== $scope.items.length);
		  };

		  $scope.isChecked = function() {
		    return $scope.selected.length === $scope.items.length;
		  };

		  $scope.toggleAll = function() {
		    if ($scope.selected.length === $scope.items.length) {
		      $scope.selected = [];
		    } else if ($scope.selected.length === 0 || $scope.selected.length > 0) {
		      $scope.selected = $scope.items.slice(0);
		    }
		  };*/
		
		  	self.doPayment = function(){
			  console.log('DO PAYMENT');
			self.transaction.transactionAmount=0;
			self.transaction.transactionsDescriptionDetails='';
				  console.log('LENGTH OF INVOICE TO PAY ', self.invoiceToPay.length);
				   for(var i = 0; i<self.invoiceToPay.length; i++){
						 console.log('SELF INVOICT TO PAY ', self.invoiceToPay[i].supplierTotal);
						 console.log('SUPPLIER NAME INVOICE ', self.invoiceToPay[i].supplierName);
						 self.transaction.transactionAmount = self.transaction.transactionAmount + self.invoiceToPay[i].balance;
						 self.transaction.transactionsDescriptionDetails = self.transaction.transactionsDescriptionDetails + " | "+self.invoiceToPay[i].supplierName;
						 self.transaction.transactionOrderTo = self.invoiceToPay[i].supplierName;
						 self.invoiceToPayId = self.invoiceToPay[i].idInvoice;
						
						
					 }
				   console.log('VALOR DE INVOICE TO PAY ANTES DE BORRAR DATOS ', self.invoiceToPay);
				 //  self.invoiceToPay=[];
				   console.log('VALOR DE INVOICE TO PAY DESPUES DE BORRAR DATOS ', self.invoiceToPay);
				   $('#myModal').modal('hide');
				   
		  }
		  
		 /* $scope.exists = function (item) {
			  console.log('EXIST ', item);
			 console.log('CHECK BOX MODEL ONE ',$scope.checkboxModelOne)
			 };*/
			 
			 /* $scope.exists = function (item, list) {
				  console.log('LIST ', list);
				  console.log('EXIST ', item);
				    return list.indexOf(item) > -1;
				  };*/
			 
			 $scope.toggle = function (item) {
				 console.log('ITEM ', item);
				// console.log('LIST ', list);
				 //var idx = list.indexOf(item);
				 var idx = self.invoiceToPay.indexOf(item);
				 console.log('VALOR DE IDX ', idx);
				 			    
				   
				    if (idx > -1) {
				    	console.log('PASAMOS AL SPLICE');
				      
				      self.invoiceToPay.splice(idx,1);
				      console.log('SELF INVOICT TO PAY ', self.invoiceToPay);
				    }
				    else {
				      self.invoiceToPay.push(item);
				  		
							 console.log('SELF INVOICT TO PAY ', self.invoiceToPay);
						
						 
				    }
				  };
				  
				  
				  $scope.exists = function (item, list) {
					  
					    return list.indexOf(item) > -1;
					  };
			  
		/*-------------------- This Function trigger when select a Bank Account under bank_transaction.jsp Fomr -------------------*/
		
		$scope.selectBankAcc = function() {
			  // $scope.item.size.code = $scope.selectedItem.code
			   console.log('Function Update Select', $scope.bankSelected);
			   window.location = REST_SERVICE_URI+"#/transactions/"+$scope.bankSelected.idBank;
			   self.getBankTransactions($scope.bankSelected.idBank);
			   // use $scope.selectedItem.code and $scope.selectedItem.name here
			   // for other stuff ...
			}
		
		self.getAllInvoice = function()   								// Read Function (retrieve all Invoice for Select )
		{     
        	 
			serviceSupplier.getBankTransactions()
     	              .then(
     	            		  function(d) {
     	            			 self.dataPayment = d;
     						        console.log('valor de dataPayment');
     						        console.log($scope.dataPayment);
     						        
     					       },
          			function(errResponse){
          			console.error('Error while fetching Currencies');
          		}
             );
          };
		
         
          
          
		$scope.selectInvoice = function(){
			$(".field").css("background-color", "#D6D6FF")
			console.log('Entramos a Select INvoiice');
			console.log('Valor de select',self.transaction.trasactionType);
			if(self.transaction.trasactionType=='Payment To Supplier Invoice'){
				console.log('vamos a  payments invoice');
				
				self.getAllInvoice();
			}
			
		}
		
		/*------------------------- Function to select Bank Options from DB-----------------------------*/
		
		 self.fetchAllBanksAcc = function(){
             UserService.fetchAllUsers()
                 .then(
     					       function(d) {
     					    	  $scope.dataBanks.bankOptions=d;
     					       },
           					function(errResponse){
           						console.error('Error while fetching Currencies');
           					}
     			       );
         };
		
	     /*------------------------ CRUD Functions --------------------------*/
		
		 self.createTransaction = function(transaction){										// Create Function (Add new Transaction)
			 serviceTransaction.createTransaction(transaction)
		              .then(function(d) {
					        self.alltransactions = d;
					        console.log('valor de d');
					        console.log('PEDIMOS TODOS LAS TRANSACTIONS DEL VALOR DE ID DESPUES DE GRABAR DATOS', $scope.idBank);
					        console.log(self.alltransactions);
					        self.itemsAndBalance();
				       },
		            		  console.log('REGRESAR DESPES DE GRABAR'),
		            		//  self.getBankTransactions($scope.idBank), 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                 );
         };
         
         self.createTransactionToPay = function(transaction,id){										// Create Function (Add new Transaction To Pay)
			 serviceTransaction.createTransactionToPay(transaction,id)
		              .then(function(d) {
					        self.alltransactions = d;
					        console.log('valor de d');
					        console.log('PEDIMOS TODOS LAS TRANSACTIONS DEL VALOR DE ID DESPUES DE GRABAR DATOS', $scope.idBank);
					        console.log(self.alltransactions);
					        self.itemsAndBalance();
				       },
		            		  console.log('REGRESAR DESPES DE GRABAR'),
		            		//  self.getBankTransactions($scope.idBank), 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                 );
         };
		
		self.getBankTransactions = function(idBank)   								// Read Funtion (retrieve all Transactions by id)
		{     
        	 
     		     serviceTransaction.getBankTransactions(idBank)
     	              .then(
     	            		  function(d) {
     						        self.alltransactions = d;
     						        console.log('valor de d');
     						        console.log('PEDIMOS TODOS LAS TRANSACTIONS DEL VALOR DE ID', $scope.idBank);
     						        console.log(self.alltransactions);
     						        if(self.alltransactions.length!=0){
     						        	console.log('EXIST TRANSACTIONS');
     						        	self.itemsAndBalance();
     						        }else{
     						        	console.log(' NOT TRANSACTIONS YET');
    						        }
     					       },
          			function(errResponse){
          			console.error('Error while fetching Currencies');
          		}
             );
          };
       
          self.updateUser = function(transaction, id){										// Update Transaction
				console.log('ANTES DE UPDATE TRANSACTION');
					serviceTransaction.updateTransaction(transaction, id)
					.then(function(d){
						console.log('Recibimos Data update ', d);
						self.alltransactions = d;
						 self.itemsAndBalance();
					}
			            		 
					             	
	                  );
	          };
	          
          
          self.deleteUser = function(id)					 						// Delete function (delete transaction by id) 
          {
        	  serviceTransaction.deleteTransaction(id)
        	  .then(function(d){
        		  self.alltransactions=d;
        		  self.itemsAndBalance();
        	  });
        	  
        	  self.reset();
			
          };
          
          
          /*----------------------- Submit Function Form check Add or Update functions ---------------------------*/
         
          self.submit = function() {
  			
  			if (self.transaction.idTransactions == null) {
  				
  				// Add the bank Object to Transactions Object send to save transaction 
  					
  				if(!self.alltransactions.length==0){
  						
  						self.transaction.bank.idBank = self.alltransactions[0].bank.idBank;
  						self.transaction.bank.nameBank = self.alltransactions[0].bank.nameBank;
  						self.transaction.bank.initialDate = self.alltransactions[0].bank.initialDate;
  						self.transaction.bank.accountNumber = self.alltransactions[0].bank.accountNumber;
  						self.transaction.bank.initialBalance = self.alltransactions[0].bank.initialBalance;
  						console.log('Saving New Transaction', self.transaction);
  					}
  				console.log('VALOR DE CHECKBOXMODEL ONE ', self.invoiceToPayId);
  				
  				if(self.invoiceToPayId){
  					console.log('PASAMOS A TRANSACTION TO PAY');
  				//	self.createTransaction(self.transaction, self.invoiceToPayId);
  					self.createTransactionToPay(self.transaction,self.invoiceToPayId);
  				}else{
  					console.log('VAMOS A GRABAR TRANSACTION ', self.transaction, 'con id bank ', $routeParams.idBank);
  					self.createTransaction(self.transaction);
  				}
  				    
  					
  					
  			} else {
  				console.log('Transaction is updated with id ', self.transaction.idTransactions, 'And Object ', self.transaction);				
  				self.updateUser(self.transaction, self.transaction.idTransactions);
  				
  			}
  			self.reset();
  		};		// End newTransaction or Update Transaction
  		
  		
          
          
          /*------------------- Edit and Remove Functions Form----------------------*/
          
          self.edit = function(id) {
				console.log('id to be edited', id);
				
				for (var i = 0; i < self.alltransactions.length; i++) {
					if (self.alltransactions[i].idTransactions == id) {
					
						self.transaction = angular.copy(self.alltransactions[i]);
						self.transaction.transactionsDate = new Date(self.alltransactions[i].transactionsDate);
						self.transaction.transactionsDateOperation = new Date(self.alltransactions[i].transactionsDateOperation);
						console.log('initial Date', self.transaction.transactionsDate);
						console.log('initial Operations Date', self.transaction.transactionsDateOperation);
						// window.location = "http://localhost:8180/AdminVedatech.dm16.2.1/#/transactions/"+self.trans.bank.idBank;
						
						break;
					}
				}
			};
			
			 self.remove = function(id){
	              console.log('id to be deleted', id);
	              if(self.alltransactions.idTransactions === id) {//clean form if the user to be deleted is shown there.
	               //  self.reset();
	              }
	              self.deleteUser(id);
	          };
         
        /*-------------------------------- Start the funcion and retrieve all transaction by id ------------------------ */
	          
          console.log('Retrieve all transactions by id bank for calling Read funcion in CRUD');
          self.getBankTransactions($routeParams.idBank);
          self.fetchAllBanksAcc();
     
        /*------------------------------- Reset Form ------------------------------------------------------------------*/
          
          self.reset = function(){
        	  console.log("DAMOS UN RESET AL FORM");
         	 self.transaction={
         				bank:{idBank:null, nameBank:'', initialDate:'', accountNumber:'', initialBalance:''},
         				idTransactions:null,
         				transactionsDate:'',
         				transactionsDateOperation:'',
         				trasactionType:'Check in',
         				transactionNum:'',
         				transactionOrderTo:'',
         				transactionAmount:null,
         				transactionDepositAmount:'',
         				balance:'',
         				transactionsDescriptionDetails:''	
         			};
         	 
         	
         	self.invoiceToPay=[];
     		$scope.myForm.$setPristine(); //reset Form
             
          } 
         /*--------------------------- Calculate Balance Function -----------------------------*/

            self.itemsAndBalance = function(){
      		console.log('inital Balance ', self.alltransactions[0].bank.initialBalance);
      		console.log('transactionDeposit Amount ', self.alltransactions[0].transactionDepositAmount);
      		
      		self.alltransactions[0].balance = self.alltransactions[0].bank.initialBalance + self.alltransactions[0].transactionDepositAmount- self.alltransactions[0].transactionAmount;
      		for(var i = 1; i < self.alltransactions.length; i++){
      			
      			//console.log('RECIBIMOS DE AmountDeposit ', self.users[i].transactionDepositAmount);
      			//console.log('RECIBIMOS DE Bank Name ', self.users[i].bank.nameBank);
      			console.log('valor del cheque ',self.alltransactions[i-1].transactionAmount);
      			self.alltransactions[i].balance = self.alltransactions[i-1].balance + self.alltransactions[i].transactionDepositAmount - self.alltransactions[i].transactionAmount;
      			//console.log('Balance ', self.users[i].balance);
      		
      		}
      		
      	}
            
         /*---------------------------- Get all Banks Account -------------------------------------*/
            
           
}]);