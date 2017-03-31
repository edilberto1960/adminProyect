<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="weatherApp"><!-- ng-app="weatherApp" ng-controller="mainController" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.css">
<link href="<c:url value='/res/css/app.css' />" rel="stylesheet"></link>
<title>Insert title here</title>
<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="/">AngularJS Weather</a>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://localhost:8180/AdminVedatech.dm16.2.1/"><i class="fa fa-home"></i> Home</a></li>
					<li><a href="#/test"><i class="fa fa-home"></i>Test </a></li>
					<li><a href="#/bank"><i class="fa fa-home"></i> Bank</a></li>
					<li><a href="#/transactions"><i class="fa fa-home"></i> Transactions</a></li>
					<li><a href="#/supplier"><i class="fa fa-home"></i> Supplier</a></li>
					
				</ul>
			</div>
			</nav>
</head>
<body>

<c:out value="${resultado}"></c:out>
	<div class="container">

		<div ng-view></div>
		
	</div>
 <!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script> -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="https://code.angularjs.org/1.4.4/angular-route.min.js"></script>
	<script src="https://code.angularjs.org/1.4.4/angular-resource.min.js"></script>
	
	<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"> -->
      <script src='<c:url value="/res/js/app.js" />'></script>
       <script src='<c:url value="/res/js/service/service.js"/>'></script>
       <script src='<c:url value="/res/js/service/service-transaction.js"/>'></script>
       <script src='<c:url value="/res/js/service/service-supplier.js"/>'></script>
      <script src='<c:url value="/res/js/controller/controller.js"/>'></script>
      <script src='<c:url value="/res/js/filters/balance-filter.js"/>'></script>
      <script src='<c:url value="/res/js/controller/transaction-controller.js"/>'></script>
      <script src='<c:url value="/res/js/controller/supplier-controller.js"/>'></script>
      <script src='<c:url value="/res/js/configuration/routes.js"/>'></script>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
       <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
       
      <script src='<c:url value="/res/js/bootstrapjs/bootstrap.min.js"/>'></script>
      
</body>
</html>