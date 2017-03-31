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
                              <label class="col-md-2 control-lable" for="file">Select Bank</label>
                              <div class="col-md-7">
                                  <select name="mySelect" id="mySelect" 
      									ng-options="item.nameBank for item in dataBanks.bankOptions track by item.idBank"
      									ng-model="bankSelected" ng-change="selectBankAcc()"></select>
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Initial Date</label>
                              <div class="col-md-7">
                                   <input type="date" ng-model="ctrl.transaction.transactionsDate" class="form-control input-sm" placeholder="Enter the Initial Date. [MM/dd/yyyy]"/> 
								<!-- <label for="exampleInput">Pick a date in 2013:</label> <input
									type="date" name="uname" ng-model="ctrl.user.initialDate" placeholder="MM/dd/yyyy" required /> -->
								
							</div>
                      </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Operation Date</label>
                              <div class="col-md-7">
                                   <input type="date" ng-model="ctrl.transaction.transactionsDateOperation" class="form-control input-sm" placeholder="Enter the Initial Date. [MM/dd/yyyy]"/> 
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
                                  <select  class="field" name="mySelect" ng-init="ctrl.transaction.trasactionType=dataType[0]"
      									ng-options="option for option in dataType"
      									ng-model="ctrl.transaction.trasactionType" ng-change="selectInvoice()"></select>
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                 <button type="button" class="btn-group-xs btn-primary" data-toggle="modal" data-target="#myModal" ng-show="ctrl.transaction.trasactionType == 'Payment To Supplier Invoice'">Select Invoice</button>
                                  </div>
                                     
                              </div>
                            
                          </div>
                     
                     
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Account Number</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.transaction.transactionNum" name="transactionNum" class="form-control input-sm" placeholder="Enter your transaction Number" required/>
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
                                  <input type="text" ng-model="ctrl.transaction.transactionOrderTo" name="transactionOrderTo" class="form-control input-sm" placeholder="Enter your transaction Number" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                       <!-- <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file" ng-show="ctrl.transaction.trasactionType == 'Payment To Supplier Invoice'">Select Invoice for Payment</label>
                              <div class="col-md-7">
                                  <select name="mySelect" id="mySelect" ng-show="ctrl.transaction.trasactionType == 'Payment To Supplier Invoice'"
      									ng-options="item.supplierTotal group by item.supplierName for item in dataPayment"
      									ng-model="bankSelected"></select>
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div> -->
                      
                      <div class="row" >
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file" ng-show="ctrl.transaction.trasactionType =='Check in' || ctrl.transaction.trasactionType == 'Payment To Supplier Invoice'" ng-model="ctrl.transaction.transactionAmount">Transaction Amount Check</label>
                              <div class="col-md-7">
                                  <input type="number" ng-show="ctrl.transaction.trasactionType =='Check in' || ctrl.transaction.trasactionType == 'Payment To Supplier Invoice'" ng-model="ctrl.transaction.transactionAmount" name="transactionAmount" class="form-control input-sm" placeholder="Enter your transaction Number"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file" ng-show="ctrl.transaction.trasactionType =='other to Deposit' || ctrl.transaction.trasactionType == 'Deposit from Clients Invoice'" ng-model="ctrl.transaction.transactionDepositAmount">Deposit Amount</label>
                              <div class="col-md-7">
                                  <input type="number" ng-show="ctrl.transaction.trasactionType =='other to Deposit' || ctrl.transaction.trasactionType == 'Deposit from Clients Invoice'" ng-model="ctrl.transaction.transactionDepositAmount" name="transactionDepositAmount" class="form-control input-sm" placeholder="Enter your Deposit Amount" 
                                  step="0.01" />
                                  <!-- <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                 </div> -->
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Descriptions </label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.transaction.transactionsDescriptionDetails" name="transactionsDescriptionDetails" class="form-control input-sm" placeholder="Enter your transactions Description Details" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.transaction.idTransactions ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm">
                              <!-- <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button> -->
                          </div>
                      </div>
                  </form>
                  
                  
                  <div class="row">
                  <div class="col-md-4"><h4 ng-bind="ctrl.alltransactions[0].bank.nameBank"></h4></div>
                  <div class="col-md-3"><h4 ng-bind="ctrl.alltransactions[0].bank.accountNumber"></h4></div>
                  <div class="col-md-3"><h4 ng-bind="ctrl.alltransactions[0].bank.initialBalance | currency"></h4></div>
                  </div>
                  
              </div>
          </div> <!-- end panel default -->



<div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Transactions Bank </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th class="col-md-1">Id Tran.</th>
                              <th>Trans Date</th>
                              <th>Operation Date</th>
                              <th>Transaction Type</th>
                              <th>Transaction Number</th>
                               <th class="col-md-3">Order To</th>
                                <th>Transaction Check Amount</th>
                                 <th>Transaction Deposit Amount</th>
                                 <th>Balance</th>
                                  <th class="col-md-3">Transaction Detalis</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                      
                          <tr ng-repeat="u in ctrl.alltransactions">
                              <td><span ng-bind="u.idTransactions"></span></td>
                              <td><span ng-bind="u.transactionsDate | date:'MM/dd/yyyy'"></span></td>
                              <td><span ng-bind="u.transactionsDateOperation | date:'MM/dd/yyyy'"></span></td>
                              <td><span ng-bind="u.trasactionType"></span></td>
                              <td><span ng-bind="u.transactionNum"></span></td>
                              <td><span ng-bind="u.transactionOrderTo"></span></td>
                              <td><span ng-bind="u.transactionAmount | currency"></span></td>
                              <td><span ng-bind="u.transactionDepositAmount | currency"></span></td>
                              <td><span ng-bind="u.balance | currency"></span></td>
                              <td><span ng-bind="u.transactionsDescriptionDetails"></span></td>
                           <td>
                              <button type="button" ng-click="ctrl.edit(u.idTransactions)" class="btn btn-xs btn-primary custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.idTransactions)" class="btn btn-xs btn-danger custom-width">Remove</button>
                           </td>  
                          
                          </tr>
                          
                      </tbody>
                  </table>
              </div>
          </div>
         
          
          <!--   Form type Modal is in Test                    -->
    <div id="dialog" title="Basic dialog">
  <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
</div>
       
          <!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        
        
       <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Transactions Bank </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th class="col-md-1">Id Invoice</th>
                              <th>Supplier Name Date</th>
                              <th>Supplier Total</th>
                              <th>Balance Invoice</th>
                              
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                      
                          <tr ng-repeat="role in ctrl.dataPayment">
                              <td><span ng-bind="role.idInvoice"></span></td>
                              <td><span ng-bind="role.supplierName"></span></td>
                              <td><span ng-bind="role.supplierTotal"></span></td>
                               <td><span ng-bind="role.balance"></span></td>

											<td>
												<input type="checkbox" ng-model="checkboxModelOne" value="{{role}}" id="{{role.idInvoice}}" ng-checked="selection.indexOf(role) > -1"
												 ng-click="toggle(role)">
												 <tt>Value = {{checkboxModelOne}}</tt><br/> 
   												<!-- <input type="checkbox" data-checklist-model="user.roles" data-checklist-value="role"  ng-click="toggle1()" /> --> 
											</td>

										</tr>
                          
                      </tbody>
                  </table>
              </div>
          </div>
      

<!--
Copyright 2016 Google Inc. All Rights Reserved. 
Use of this source code is governed by an MIT-style license that can be foundin the LICENSE file at http://material.angularjs.org/HEAD/license.
-->
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" ng-click="ctrl.doPayment()">Pay Selected Invoice</button>
      </div>
    </div>
  </div>
</div>



 </div>
            
</body>
</html>