'use strict'
angular.module('weatherApp').controller('SupplierController', ['$scope','$routeParams', 'serviceSupplier','UserService', function($scope,$routeParams, serviceSupplier, UserService) {
	
		var self = this;
	
		self.supplierInvoice={
			
			idInvoice:null,
			transactionsDate:'',
			supplierName:'',
			supplierTotal:null
			
		};
		
		
		self.allSupplierInvoice=[];
			
				
		
		$scope.selectBankAcc = function() {
			  // $scope.item.size.code = $scope.selectedItem.code
			   console.log('Function Update Select', $scope.bankSelected);
			   window.location = REST_SERVICE_URI+"#/transactions/"+$scope.bankSelected.idBank;
			   self.getBankTransactions($scope.bankSelected.idBank);
			   // use $scope.selectedItem.code and $scope.selectedItem.name here
			   // for other stuff ...
			}
		
		/*------------------------- Function to select Bank Options -----------------------------*/
		
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
		
		 self.createTransaction = function(addInvoice){										// Create Function (Add new Transaction)
			 serviceSupplier.createTransaction(addInvoice)
		              .then(function(d) {
					        self.alltransactions = d;
					        console.log('valor de d');
					        console.log('PEDIMOS TODOS LAS TRANSACTIONS DEL VALOR DE ID DESPUES DE GRABAR DATOS', $scope.idBank);
					        console.log(self.alltransactions);
			//		        self.itemsAndBalance();
					        self.getAllInvoice();
				       },
		            		  console.log('REGRESAR DESPES DE GRABAR'),
		            		//  self.getBankTransactions($scope.idBank), 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                 );
         };
		
		self.getAllInvoice = function()   								// Read Function (retrieve all Transactions by id)
		{     
        	 
			serviceSupplier.getBankTransactions()
     	              .then(
     	            		  function(d) {
     	            			 self.allSupplierInvoice = d;
     						        console.log('valor de d');
     						        console.log(self.allSupplierInvoice);
     						        
     					       },
          			function(errResponse){
          			console.error('Error while fetching Currencies');
          		}
             );
          };
       
          self.updateUser = function(transaction, id){										// Update Transaction
				console.log('ANTES DE UPDATE TRANSACTION');
				serviceSupplier.updateTransaction(transaction, id)
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
			
          };
          
          
          /*----------------------- Submit Function Form check Add or Update functions ---------------------------*/
         
          self.submit = function() {
  			
  			if (self.supplierInvoice.idSupplier == null) {
  				
  				// Add the bank Object to Transactions Object send to save transaction 
  					
  				/*if(!self.alltransactions.length==0){
  						
  						self.transaction.bank.idBank = self.alltransactions[0].bank.idBank;
  						self.transaction.bank.nameBank = self.alltransactions[0].bank.nameBank;
  						self.transaction.bank.initialDate = self.alltransactions[0].bank.initialDate;
  						self.transaction.bank.accountNumber = self.alltransactions[0].bank.accountNumber;
  						self.transaction.bank.initialBalance = self.alltransactions[0].bank.initialBalance;
  						console.log('Saving New Transaction', self.transaction);
  					}*/
  				    
  					console.log('VAMOS A GRABAR TRANSACTION ', self.supplierInvoice);
  					//self.createTransaction(self.transaction, $routeParams.idBank);
  					self.supplierInvoice.balance = self.supplierInvoice.supplierTotal;
  					self.createTransaction(self.supplierInvoice);
  					
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
          self.getAllInvoice();
          
     
        /*------------------------------- Reset Form ------------------------------------------------------------------*/
          
          self.reset = function(){
         	 self.transaction={
         				bank:{idBank:null, nameBank:'', initialDate:'', accountNumber:'', initialBalance:''},
         				idTransactions:null,
         				transactionsDate:'',
         				transactionsDateOperation:'',
         				trasactionType:'Check in',
         				transactionNum:'',
         				transactionOrderTo:'',
         				transactionAmount:'',
         				transactionDepositAmount:'',
         				balance:'',
         				transactionsDescriptionDetails:''	
         			};
              $scope.myForm.$setPristine(); //reset Form
          };
          
         /*--------------------------- Calculate Balance Function -----------------------------*/

       /*     self.itemsAndBalance = function(){
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
      		
      	}*/
            
         /*---------------------------- Get all Banks Account -------------------------------------*/
            
           
}]);