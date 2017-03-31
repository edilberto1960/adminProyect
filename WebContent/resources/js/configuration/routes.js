'use strict';

weatherApp.config(function($routeProvider){
	console.log('routes');
	console.log($routeProvider);
	$routeProvider
		
	.when('/test', {
		templateUrl: 'get/test',
		//controller: 'secondController'
	})
	.when('/bank', {
		templateUrl: 'get/bankpage',
		//controller: 'mainController'
	})
	.when('/transactions/:idBank', {
		templateUrl: 'get/transactions',
		//controller: 'TransController'
	})
	.when('/edit/transactions/:idBank', {
		templateUrl: 'get/edit/transactions',
		//controller: 'TransController'
	})
	.when('/list',{
		templateUrl: 'get/banklist',
		//controller: 'UserController'
	})
	.when('/supplier',{
		templateUrl: 'get/supplier'
	});
	
	

});
