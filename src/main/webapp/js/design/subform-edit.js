angularApp.controller('SubFormEditController', [
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
			$scope.propSubformId = $attrs.model;
			$scope.propFormName='';
			$scope.propFormOrder = 0;
			$scope.propParentFormId={};
			$scope.propFormStatus=1;
			$scope.form = $builder.forms['default'];
			$scope.formOrigin =[];
			
			
			$http.get(_contextPath+'/web/formdesign/subform/data/'+$scope.propSubformId).
		        success(function(data) {
		            $scope.response = data;
		            $scope.propParentFormId = $scope.response.parentFormId;
		            $scope.propFormName = $scope.response.formName;					
		            $scope.propFormOrder = $scope.response.formOrder;
		            $scope.propFormStatus = $scope.response.formStatus;
					$scope.propSubformId = $attrs.model;

		            var formDetailUpdated = angular.fromJson($scope.response.formDetailUpdated);
					angular.forEach(formDetailUpdated, function(comp) {
						 $scope.form.push(comp);
					});
					
					var formDetail = angular.fromJson($scope.response.formDetail);
					angular.forEach(formDetail, function(comp) {
						 $scope.formOrigin.push(comp);
					});
		        });
			
			$scope.input = [];
			$scope.defaultValue = {};
			
			$scope.save = function() {
				var formDetail = angular.toJson($scope.form);
				var formDetailOrigin = angular.toJson($scope.formOrigin);
				
				$scope.data={};
				$scope.data.id=$scope.propSubformId;
				$scope.data.formName = $scope.propFormName;
				$scope.data.formDetail = formDetailOrigin;
				$scope.data.formDetailUpdated = formDetail;
				$scope.data.parentFormId = $scope.propParentFormId
				$scope.data.formOrder = $scope.propFormOrder;
				if ($scope.propFormStatus == 4) {
					$scope.data.formStatus = 2; 
				} else {
					$scope.data.formStatus = $scope.propFormStatus
				}
				
				$http.post(_contextPath+'/web/formdesign/subform/update', $scope.data).
			        success(function(data) {					
						var result = data;
			        	if (result.indexOf('error') == -1) {
			        		$window.location.href= _contextPath+"/web/formdesign/subform/list?formId="+$scope.data.parentFormId+"&message="+result;
			        	} else {
			        		$window.location.href= _contextPath+"/web/formdesign/subform/list?formId="+$scope.data.parentFormId+"&error="+result;
			        	}	
			        });
				
			};
			
			$scope.cancel = function() {
				$window.location.href=_contextPath+"/web/formdesign/subform/list?formId="+$scope.propParentFormId;
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
