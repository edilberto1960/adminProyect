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
City: {{localCity}}
<a href="#/list">Bank List</a>

<div class="generic-container" ng-controller="secondController as ctrl">

<div ng-model="ctrl.localCity"></div>
</div>          
</body>
</html>