var cartApp = angular.module('cartApp', [ 'ngCart' ]);

cartApp.controller('cartCtrl', [ '$scope', '$http', 'ngCart',
		function($scope, $http, ngCart) {
			ngCart.setTaxRate(0);
			ngCart.setShipping(0);
		} ]);