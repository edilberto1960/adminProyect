'use strict'

weatherApp.service('serviceSupplier', ['$http', '$q', function($http, $q) {
	
	//var transaction ='http://localhost:8180/AdminVedatech.dm16.2.2/get/transactionsby/';

					return {
								getBankTransactions : function() {

									return $http
											.get(
													REST_SERVICE_URI+'get/allsupplierinvoice/')
											.then(
													function(response) {
														console.log('data supplier ', response.data);
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while creating suppliers list');
														return $q
																.reject(errResponse);
													});
								},
								
								createTransaction: function(invoice){
									return $http.post(REST_SERVICE_URI+'save/invoice/',invoice)
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