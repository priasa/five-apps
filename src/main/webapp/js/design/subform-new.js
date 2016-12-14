angularApp.controller('SubFormNewController', [
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
			$scope.propParentFormId = $attrs.model;
			$scope.propFormOrder = null;
			
			$scope.form = $builder.forms['default'];
			$scope.input = [];
			$scope.defaultValue = {};
			
			$scope.save = function() {
				var formDetail = angular.toJson($scope.form);

				$scope.data={};
				$scope.data.formName = $scope.propFormName;
				$scope.data.formOrder = $scope.propFormOrder;
				$scope.data.parentFormId = $scope.propParentFormId;
				$scope.data.formDetail = formDetail;
				$scope.data.formDetailUpdated = formDetail;
				$scope.data.formStatus = 1;
				$http.post(_contextPath+'/web/formdesign/subform/save', $scope.data).
		        success(function(data) {
		        	var result = data;
		        	if (result.indexOf('error') == -1) {
		        		$window.location.href= _contextPath+"/web/formdesign/subform/list?formId="+$scope.propParentFormId+"&message="+result;
		        	} else {
		        		$window.location.href= _contextPath+"/web/formdesign/subform/list?formId="+$scope.propParentFormId+"&error="+result;
		        	}					
		        });
				
			};
						
			$scope.cancel = function() {
				$window.location.href= _contextPath+"/web/formdesign/subform/list?formId="+$scope.propParentFormId;
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
