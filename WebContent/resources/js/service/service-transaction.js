'use strict'

weatherApp.service('serviceTransaction', ['$http', '$q', function($http, $q) {
	
	
	// var REST_SERVICE_URI = 'http://localhost:8080/AdminVedatech.dm16.2.3';
					return {
								getBankTransactions : function(idBank) {

									return $http
											.post(
													REST_SERVICE_URI+'get/transactionsby/'+idBank)
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while creating user');
														return $q
																.reject(errResponse);
													});
								},
								
								createTransaction: function(transaction){
									return $http.post(REST_SERVICE_URI+'save/transaction/',transaction)
											.then(
													function(response){
														console.log('AFTER SAVE TRANSACTION',response.data)
														return response.data;
													}, 
													function(errResponse){
														console.error('Error while creating user to the post');
														return $q.reject(errResponse);
													}
											);
						    },
						    
						    createTransactionToPay: function(transaction,idBank){
								return $http.post(REST_SERVICE_URI+'save/transactiontopay/'+idBank,transaction)
										.then(
												function(response){
													console.log('AFTER SAVE TRANSACTION',response.data)
													return response.data;
												}, 
												function(errResponse){
													console.error('Error while creating user to the post');
													return $q.reject(errResponse);
												}
										);
					    },
						    
						    updateTransaction: function(transaction, idBank){
						    	console.log('MANDAMOS UN REQUESTES');
								return $http.put(REST_SERVICE_URI+'updatetransaction/'+idBank, transaction)
										.then(
												function(response){
													console.log('Data received ', response);
													return response.data;
												}, 
												function(errResponse){
													console.error('Error while updating user');
													return $q.reject(errResponse);
												}
										);
						},
						
						deleteTransaction: function(id){
							return $http.delete(REST_SERVICE_URI+'deletetransaction/'+id)
									.then(
											function(response){
												return response.data;
											}, 
											function(errResponse){
												console.error('Error while deleting user');
												return $q.reject(errResponse);
											}
									);
					}
						    
							};
							
		
	
}]);