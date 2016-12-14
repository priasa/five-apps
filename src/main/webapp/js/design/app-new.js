angularApp.controller('NewController', [
		'$scope',
		'$builder',
		'$validator',
		'$route',
		'$routeParams',
		'$location',
		'$attrs',
		'$window',
		'$http',
		'AppFactory',
		function($scope, $builder, $validator, $route, $routeParams, $location, $attrs, $window, $http, AppFactory) {
			$scope.propFormName='';
			$scope.enableWorkflow = false;
			$scope.form = $builder.forms['default'];
			$scope.input = [];
			$scope.defaultValue = {};
			$scope.propRecipientNotification='';
			$scope.save = function() {
				var formDetail = angular.toJson($scope.form);

				$scope.data={};
				$scope.data.formName = $scope.propFormName;
				$scope.data.formDetail = formDetail;
				$scope.data.draft = false;
				$scope.data.enableWorkflow = $scope.enableWorkflow;
				$scope.data.recipientNotification = $scope.propRecipientNotification;
				
				$http.post(_contextPath+'/web/formdesign/save', $scope.data).
			        success(function(data) {					
						var result = data;
			        	if (result.indexOf('error') == -1) {
			        		$window.location.href= _contextPath+"/web/formdesign/list?message="+result;
			        	} else {
			        		$window.location.href= _contextPath+"/web/formdesign/list?error="+result;
			        	}	
			        });
				
			};
			
			$scope.saveAsDraft = function() {
				var formDetail = angular.toJson($scope.form);

				$scope.data={};
				$scope.data.formName = $scope.propFormName;
				$scope.data.formDetail = formDetail;
				$scope.data.draft = true;
				$scope.data.enableWorkflow = $scope.enableWorkflow;

				
				$http.post(_contextPath+'/web/formdesign/save', $scope.data).
					success(function(data) {					
						var result = data;
			        	if (result.indexOf('error') == -1) {
			        		$window.location.href= _contextPath+"/web/formdesign/list?message="+result;
			        	} else {
			        		$window.location.href= _contextPath+"/web/formdesign/list?error="+result;
			        	}	
			        });
				
				
			};
			
			$scope.cancel = function() {
				$window.location.href= _contextPath+"/web/formdesign/list";
			};
			return $scope.submit = function() {
				return $validator.validate($scope, 'default').success(
						function() {
							return console.log('success');
						}).error(function() {
					return console.log('error');
				});
			};
		} ]);
