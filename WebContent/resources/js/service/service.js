'use strict';

weatherApp.factory('UserService', ['$http', '$q', function($http, $q){

//	 var REST_SERVICE_URI = 'http://localhost:8080/AdminVedatech.dm16.2.3';
		
	return {
		
			fetchAllUsers: function() {
					return $http.get(REST_SERVICE_URI+'get/banklist')
							.then(
									function(response){
										console.log('regerzamos del get');
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createUser: function(user){
					return $http.post(REST_SERVICE_URI+'add', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateUser: function(user, idBank){
					return $http.put(REST_SERVICE_URI+'user/'+idBank, user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteUser: function(id){
					return $http.delete(REST_SERVICE_URI+'user/'+id)
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
