var albumApp = angular.module('vgrsViewApp', []);


albumApp.controller('LoginViewController', ['$scope','$http', '$location', function($scope, $http, $location) {
	
	$scope.rgdata = {};
	
	$scope.validateRegister = function() {
		console.log("HERE");
		var creds = $scope.rgdata;
		
		$http.post('register.do', { 
				"username" : creds.username,
				"password" : creds.password,
				"email": creds.email,
				"name" : creds.name
			}).then(function successCallback(response) {
				console.log(response);
				$location.path("/");
		  }, function errorCallback(response) {
		});
	}
	
	$scope.validatePassword = function() {
		var password = document.getElementById("passwordReg");
		var confirm_password = document.getElementById("passwordConfirmReg");

		if(password.value != confirm_password.value) {
			confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
			confirm_password.setCustomValidity('');
		}
	}
}]);