<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Transactons</h1>
<div class="container" ng-controller="TransController as ctrl">

<div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Bank Transactions Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                     <!--  <input type="text" ng-model="ctrl.user.idBank" /> -->
                      <!-- <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Bank Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.nameBank" name="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div> -->
                        
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Initial Date</label>
                              <div class="col-md-7">
                                   <input type="date" ng-model="ctrl.trans.transactionsDate" class="form-control input-sm" placeholder="Enter the Initial Date. [MM/dd/yyyy]"/> 
								<!-- <label for="exampleInput">Pick a date in 2013:</label> <input
									type="date" name="uname" ng-model="ctrl.user.initialDate" placeholder="MM/dd/yyyy" required /> -->
								
							</div>
                      </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Operation Date</label>
                              <div class="col-md-7">
                                   <input type="date" ng-model="ctrl.trans.transactionsDateOperation" class="form-control input-sm" placeholder="Enter the Initial Date. [MM/dd/yyyy]"/> 
								<!-- <label for="exampleInput">Pick a date in 2013:</label> <input
									type="date" name="uname" ng-model="ctrl.user.initialDate" placeholder="MM/dd/yyyy" required /> -->
								
							</div>
                      </div>
                      </div>
                      
                      <!-- <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Transaction Type</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.trans.trasactionType" name="trasactionType" class="form-control input-sm" placeholder="Enter your trasactionType" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div> -->
                   
                     <!-- Select Transaction Option  -->
                   
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Select Transaction Type</label>
                              <div class="col-md-7">
                                  <select name="mySelect" id="mySelect" ng-init="ctrl.trans.trasactionType=dataType[0]"
      									ng-options="option for option in dataType"
      									ng-model="ctrl.trans.trasactionType"></select>
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                     
                      
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Account Number</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.trans.transactionNum" name="transactionNum" class="form-control input-sm" placeholder="Enter your transaction Number" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Order To</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.trans.transactionOrderTo" name="transactionOrderTo" class="form-control input-sm" placeholder="Enter your transaction Number" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Transaction Amount Check</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.trans.transactionAmount" name="transactionAmount" class="form-control input-sm" placeholder="Enter your transaction Number" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Deposit Amount</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.trans.transactionDepositAmount" name="transactionDepositAmount" class="form-control input-sm" placeholder="Enter your Deposit Amount" 
                                  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                 </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Descriptions </label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.trans.transactionsDescriptionDetails" name="transactionsDescriptionDetails" class="form-control input-sm" placeholder="Enter your transactions Description Details" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.trans.idTransactions ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <!-- <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button> -->
                          </div>
                      </div>
                  </form>
                  <div class="row">
                  <div class="col-md-4"><h4 ng-bind="ctrl.users[0].bank.nameBank"></h4></div>
                  <div class="col-md-3"><h4 ng-bind="ctrl.users[0].bank.accountNumber"></h4></div>
                  <div class="col-md-3"><h4 ng-bind="ctrl.users[0].bank.initialBalance | currency"></h4></div>
                  </div>
                  
              </div>
          </div> <!-- end panel default -->




          
          

                     
            
</body>
</html>