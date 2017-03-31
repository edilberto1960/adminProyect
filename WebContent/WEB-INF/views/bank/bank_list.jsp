<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
      .nameBank.ng-valid {
          background-color: lightgreen;
      }
      .nameBank.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .nameBank.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
</head>
<body>
<p id="demo"></p>
<h2>Bank</h2>
<c:out value="${resultado}"></c:out>
City: {{city}}
<a href="#/list">Bank List</a>

<div class="generic-container" ng-controller="UserController as ctrl">

<div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.idBank" />
                      <div class="row">
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
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Initial Date</label>
                              <div class="col-md-7">
                                   <input type="date" ng-model="ctrl.user.initialDate" class="form-control input-sm" placeholder="Enter the Initial Date. [MM/dd/yyyy]"/> 
								<!-- <label for="exampleInput">Pick a date in 2013:</label> <input
									type="date" name="uname" ng-model="ctrl.user.initialDate" placeholder="MM/dd/yyyy" required /> -->
								
							</div>
                      </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Account Number</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.accountNumber" name="accountNumber" class="form-control input-sm" placeholder="Enter your Account Number" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <!-- <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span> -->
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Initial Balance</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.user.initialBalance" name="initialBalance" class="form-control input-sm" placeholder="Enter your Initial Balance" 
                                  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                 </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.idBank ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div> <!-- end panel default -->



<div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Banks Accounts </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name Bank</th>
                              <th>Initial Date</th>
                              <th>Account Number</th>
                              <th>Initial Balance</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.idBank"></span></td>
                              <td><span ng-bind="u.nameBank"></span></td>
                              <td><span ng-bind="u.initialDate | date:'MM/dd/yyyy'"></span></td>
                              <td><span ng-bind="u.accountNumber"></span></td>
                              <td><span ng-bind="u.initialBalance | currency"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.idBank)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.idBank)" class="btn btn-danger custom-width">Remove</button>
                              <button type="button" ng-click="ctrl.transactions(u.idBank)" class="btn btn-info custom-width">Transactions</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
          </div>
          
</body>
</html>