'use strict';
 
angular.module('weatherApp').controller('mainController', ['$scope', function($scope) {
	$scope.city = 'Puebla';
	console.log('Hello');
	console.log('pasamos por users');
}]);

angular.module('weatherApp').controller('secondController', ['$scope', function($scope) {
	$scope.localCity = 'Monterrey';
	console.log('Hello Second Controller');
	console.log('pasamos por second Controller');
}]);


angular.module('weatherApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          var link='http://localhost:8180/AdminVedatech.dm16.2.3/get/banklist';
          self.user={idBank:null, nameBank:'', initialDate:'', accountNumber:'', initialBalance:''};
          self.users=[];
          self.usersFormat=[];
              
          self.fetchAllUsers = function(){
              UserService.fetchAllUsers()
                  .then(
      					       function(d) {
      						        self.users = d;
      						       
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createUser = function(user){
              UserService.createUser(user)
		              .then(
                      self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                  );
          };

         self.updateUser = function(user, id){
              UserService.updateUser(user, id)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while updating User.');
				              }	
                  );
          };

         self.deleteUser = function(id){
              UserService.deleteUser(id)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while deleting User.');
				              }	
                  );
          };

							self.fetchAllUsers();
							console.log('despues del fetchAllUsers');

							self.submit = function() {
								
								if (self.user.idBank == null) {
									console.log('Saving New User', self.user);
									for(var i= 0; i < self.users.length; i++){
										if(self.user.nameBank == self.users[i].nameBank && self.user.accountNumber == self.users[i].accountNumber){
											console.log('Existe una cuenta con el mismo nombre y numero de Cuenta');
											myFunction();
											self.reset();
											return;
										}else{
										
										}
										
									}
									 self.createUser(self.user);
								} else {
									self.updateUser(self.user, self.user.idBank);
									console.log('User updated with id ', self.user.idBank);
								}
								self.reset();
							};
              

							
							    self.edit = function(id) {
								console.log('id to be edited', id);
								console.log('lenght of users ', self.users.length);
								console.log('valor de users 0 ', self.users[0].idBank);
								for (var i = 0; i < self.users.length; i++) {
									if (self.users[i].idBank == id) {

										self.user = angular.copy(self.users[i]);
										self.user.initialDate = new Date(self.users[i].initialDate);
										console.log('initial Date', self.user.initialDate);
										break;
									}
								}
							};
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.user.idBank === id) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteUser(id);
          };
          
          self.transactions = function(id){
        	  
        	  window.location = REST_SERVICE_URI+"#/transactions/"+id;
          }

          
          self.reset = function(){
        	  self.user={idBank:null, nameBank:'', initialDate:'', accountNumber:'', initialBalance:''};
              $scope.myForm.$setPristine(); //reset Form
          };
          
          function myFunction() {
        	 alert("La Cuenta ya Exisite trate de nuevo");
        	        	    
        	};
          
                	 

      }]);
