'use strict'
angular.module('weatherApp').filter('totalSumPriceQty', function (val1, val2) {
	console.log('FILTER')
	var sum = 10;
	var i=0;
   return function(quantity,price){
	   
	   console.log('Quantity ', quantity);
    	sum = sum + 1;
        
        sum;
    };
		
});   