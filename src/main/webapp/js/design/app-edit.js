angularApp.controller('EditController', [
		'$scope',
		'$builder',
		'$validator',
		'$route',
		'$routeParams',
		'$location',
		'$attrs',
		'$http',
		'$window',
		'AppFactory',
		function($scope, $builder, $validator, $route, $routeParams, $location, $attrs, $http, $window, AppFactory) {
			$scope.propFormName='';
			$scope.propRecipientNotification='';
			$scope.formStatus = 'draft';
			$scope.enableWorkflow = false;
			$scope.formId={};
			$scope.form = $builder.forms['default'];
			$scope.attribute = $attrs.model;
			
			$http.get(_contextPath+'/web/formdesign/data/'+$scope.attribute).
		        success(function(data) {
		            $scope.response = data;
		            $scope.formId = $scope.response.id;
		            $scope.propFormName = $scope.response.formName;					
					$scope.formCode = $scope.response.formCode;
					$scope.enableWorkflow = $scope.response.enableWorkflow;
					$scope.propRecipientNotification= $scope.response.recipientNotification;
					
					if ($scope.response.draft == false) {
						$scope.formStatus = "publish";
					}
					
		            var formDetail = angular.fromJson($scope.response.formDetail);
					angular.forEach(formDetail, function(comp) {
						 $scope.form.push(comp);
					});
		        });
			
			$scope.input = [];
			$scope.defaultValue = {};
			
			$scope.save = function() {
				var formDetail = angular.toJson($scope.form);
				
				$scope.data={};
				$scope.data.id=$scope.formId;
				$scope.data.formName = $scope.propFormName;
				$scope.data.formDetail = formDetail;
				$scope.data.draft = false;
				$scope.data.formCode = $scope.formCode;
				$scope.data.enableWorkflow = $scope.enableWorkflow;
				$scope.data.recipientNotification = $scope.propRecipientNotification;
				
				$http.post(_contextPath+'/web/formdesign/update', $scope.data).
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
				$scope.data.id=$scope.formId;
				$scope.data.formName = $scope.propFormName;
				$scope.data.formDetail = formDetail;
				$scope.data.draft = true;
				$scope.data.formCode = $scope.formCode;
				$scope.data.enableWorkflow = $scope.enableWorkflow;
				$scope.data.recipientNotification = $scope.propRecipientNotification;
				
				$http.post(_contextPath+'/web/formdesign/update', $scope.data).
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
				$window.location.href=_contextPath+"/web/formdesign/list";
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
