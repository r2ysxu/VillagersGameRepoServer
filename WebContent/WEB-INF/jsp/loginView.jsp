<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="vgrsViewApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="/VillagersGameRepoServer/lib/angular.min.js"></script>
	<script type="text/javascript" src="/VillagersGameRepoServer/scripts/controllers/loginController.js"></script>
	<title>Login Page</title>
</head>
<body ng-controller="LoginViewController">
    <fieldset>
        <legend>Please Login</legend>
        <c:url var="loginUrl" value="/account/login.do" />
		<form name="loginForm" action="${loginUrl}" method="POST">
			        <div id="loginMessage">${errorMessage}</div>
		        <c:if test="${param.logout}">
			        <div class="alert alert-success"> 
			            You have been logged out.
			        </div>
		        </c:if>
		        <label for="username">Username</label>
		        <input type="text" id="username" name="username"/>
		        <label for="password">Password</label>
		        <input type="password" id="password" name="password"/>
		        <div>
		            <button type="submit">Log in</button>
		        </div>
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<input type="button" value="Register">
	</fieldset>
	
	<div id="registerModal">
		<fieldset>
			<legend>Registration</legend>
			
			<form name="registerForm" action="" method="GET" ng-submit="validateRegister()" >
				<div ng-messages="registerForm.usernameReg.$error" role="alert">
			    	<div ng-message="required">Please enter a value for this field.</div>
			    	<div ng-message="taken">Username already taken</div>
			  	</div>
			  	<div ng-messages="registerForm.passwordReg.$error" role="alert">
			    	<div ng-message="required">Please enter a value for this field.</div>
			    	<div ng-message="">Password must be at least 8 characters long</div>
			  	</div>
			  	
		        <label for="usernameReg">Username</label>
				<input type="text" id="usernameReg" ng-model="rgdata.username" required />
		        <label for="passwordReg">Password</label>
				<input type="password" id="passwordReg" ng-model="rgdata.password" minlength="8" required />
		        <label for="passwordConfirmReg">Confirm Password</label>
				<input type="password" id="passwordConfirmReg" ng-model="rgdata.confirmpassword" minlength="8" 
					ng-blur="validatePassword()" required />
		        <label for="emailReg">Email</label>
				<input type="email" id="emailReg" ng-model="rgdata.email" required />
		        <label for="nameReg">Name</label>
				<input type="text" id="nameReg" ng-model="rgdata.name" required />
		    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    	<div>
		            <button type="submit">Register</button>
		        </div>
			</form>
		</fieldset>
	</div>
</body>
</html>