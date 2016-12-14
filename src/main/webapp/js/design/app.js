var angularApp = angular.module('app', [ 'builder', 'builder.components',
		'validator.rules', 'ngResource', 'ngRoute' ]);

angularApp.factory('AppFactory', function($http) {
	var urlBase = _contextPath+'/web/formdesign';
	var factory = {};

	factory.getExistingComponents = function() {
		return existingComponents;
	};
	
	factory.getFormById = function(formId) {
		 var response = $http.get(urlBase+'/data/'+formId); 
		 return response;
	};
	
	factory.save = function(data) {
		return $http.post(urlBase+'/save' , data);
	};
	
	factory.update = function(data) {
		return $http.post(urlBase+'/update' , data);
	};
	
	factory.getMasterData = function() {
		return [{name:'Gender', id:'5f62aa80-4541-4257-bdff-c11709588789', content:[{code:'M', value:'Male'},{code:'F', value:'Female'}]},
		        {name:'Currency', id:'bf74b7cc-14a2-4479-9769-30fc893caff1', content:[{code:'MYR', value:'Malaysia Ringgit'}, {code:'IDR', value:'Indonesia Rupiah'}]}];
	};

	return factory;
});

angularApp
		.run([
				'$builder','AppFactory',
				function($builder, AppFactory) {
					$builder.registerComponent('checkbox', {
				        group: 'Choices',
				        label: 'Checkbox',
				        hint: 'hint',
				        required: false,
				        options: ['value 1', 'value 2'],
				        optionsData : [],
				        sourceOptions : [
						                 {label : 'Options List',value : 'options'},
						                 {label : 'Master Data',value : 'masterData'}
						                 ],
						optionSource : {},
						masterDataOptions : AppFactory.getMasterData(),
						masterData:{},
				        arrayToText: true,
				        template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n        <input type='hidden' ng-model=\"inputText\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\"/>\n        <div class='checkbox custom-checkbox' ng-repeat=\"item in options track by $index\">\n            <label><input type='checkbox' ng-model=\"$parent.inputArray[$index]\" value='item'/><span class=\"custom-checkbox\"></span>\n                {{item}}\n            </label>\n        </div>\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
				        popoverTemplate: "<form>\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n<div class=\"form-group\" \">\n<label class='control-label'>Options Source</label>\n<select ng-model=\"optionSource\" class='form-control' ng-options=\"option.value as option.label for option in sourceOptions\"></select>\n</div>\n<div ng-show=\"optionSource == 'masterData'\" class=\"form-group\" \">\n<label class='control-label'>Master Data</label>\n<select ng-model=\"masterData\" class='form-control' ng-options=\"masterData.name for masterData in masterDataOptions track by masterData.id\"></select>\n</div>\n\n<div ng-show=\"optionSource == 'options'\" class=\"form-group\" \">\n<label class='control-label'>Options</label>\n<textarea placeholder=\"Format Code,Value\nExample:\nM,Male\" class=\"form-control\" rows=\"3\" ng-model=\"optionsText\"/>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\n            Required\n        </label>\n    </div>\n\n    <hr/>\n    <div class='form-group'>\n        <input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n        <input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
				      });
					
					$builder.registerComponent('radio', {
						group: 'Choices',
						label: 'Radio',
						hint: 'hint',
						required: false,
						options: ['value 1', 'value 2'],
						optionsData : [],
				        sourceOptions : [
						                 {label : 'Options List',value : 'options'},
						                 {label : 'Master Data',value : 'masterData'}
						                 ],
						optionSource : {},
						masterDataOptions : AppFactory.getMasterData(),
						masterData:{},
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n<div class=\"col-sm-8\">\n<div class='radio' ng-repeat=\"item in options track by $index\">\n            <label><input name='{{formName+index}}' ng-model=\"$parent.inputText\" validator-group=\"{{formName}}\" value='{{item}}' type='radio'/><span class=\"custom-radio\"></span>\n                {{item}}\n            </label>\n        </div>\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
					    popoverTemplate: "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n<div class=\"form-group\" \">\n<label class='control-label'>Options Source</label>\n<select ng-model=\"optionSource\" class='form-control' ng-options=\"option.value as option.label for option in sourceOptions\"></select>\n</div>\n<div ng-show=\"optionSource == 'masterData'\" class=\"form-group\" \">\n<label class='control-label'>Master Data</label>\n<select ng-model=\"masterData\" class='form-control' ng-options=\"masterData.name for masterData in masterDataOptions track by masterData.id\"></select>\n</div>\n\n<div ng-show=\"optionSource == 'options'\" class=\"form-group\" \">\n<label class='control-label'>Options</label>\n        <textarea placeholder=\"Format Code,Value\nExample:\nM,Male\" class=\"form-control\" rows=\"3\" ng-model=\"optionsText\"/>\n    </div>\n    <div class=\"checkbox\">\n        <label>\n            <input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\n            Required\n        </label>\n    </div>\n\n    <hr/>\n    <div class='form-group'>\n        <input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n        <input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
					
					$builder.registerComponent('selectbox', {
				        group: 'Choices',
				        label: 'Select',
				        hint: 'hint',
				        required: false,
				        options: ['value one', 'value two'],
				        optionsData : [],
				        sourceOptions : [
						                 {label : 'Options List',value : 'options'},
						                 {label : 'Master Data',value : 'masterData'}
						                 ],
						optionSource : {},
						masterDataOptions : AppFactory.getMasterData(),
						masterData:{},
				        template: "<div class=\"form-group\">\n    <label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n<select ng-options=\"value for value in options\" id=\"{{formName+index}}\" class=\"form-control\"\n            ng-model=\"inputText\" ng-init=\"inputText = options[0]\"/>\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
				        popoverTemplate: "<form>\n    <div class=\"form-group\">\n        <label class='control-label'>Label</label>\n        <input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n    </div>\n    <div class=\"form-group\">\n        <label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<label class='control-label'>Options Source</label>\n<select ng-model=\"optionSource\" class='form-control' ng-options=\"option.value as option.label for option in sourceOptions\"></select>\n</div>\n<div ng-show=\"optionSource == 'masterData'\" class=\"form-group\" \">\n<label class='control-label'>Master Data</label>\n<select ng-model=\"masterData\" class='form-control' ng-options=\"masterData.name for masterData in masterDataOptions track by masterData.id\"></select>\n</div>\n\n<div ng-show=\"optionSource == 'options'\" class=\"form-group\" \">\n<label class='control-label'>Options</label>\n        <textarea placeholder=\"Format Code,Value\nExample:\nM,Male\" class=\"form-control\" rows=\"3\" ng-model=\"optionsText\"/>\n    </div>\n    <div class=\"checkbox\">\n        <label>\n            <input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\n            Required\n        </label>\n    </div>\n\n    <hr/>\n    <div class='form-group'>\n        <input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n        <input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
				      });
					$builder.registerComponent('yesNoSwitch', {
						group : 'Choices',
						label : 'Yes/No Switch',
						hint : 'hint',
						required : false,
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n<div class=\"col-sm-8\">\n<button type=\"button\" class=\"btn btn-primary btn-lg\"><span class=\"glyphicon glyphicon-adjust\" validator-required=\"{{required}}\"></span></button>\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
					
					$builder.registerComponent('datePicker', {
						group : 'Picker',
						label : 'Date Picker',
						hint : 'hint',
						required : false,
						sourcesMode : [
						              {label : 'Date and Time',value : 'dateAndTime'},
						              {label : 'Date Only',value : 'dateOnly'},
						              {label : 'Time Only',value : 'timeOnly'}],
						dateMode : {},
						minimumDate : '',
						maximumDate : '',
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n<div class=\"col-sm-8\">\n<div class=\"input-group\">\n<input type=\"text\" ng-model=\"inputText\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\" id=\"{{formName+index}}\" class=\"datepicker form-control\" /><span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span>\n</div>\n<span class='help-block'>{{hint}}</span>\n</div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n<div class=\"form-group\" \">\n<label class='control-label'>Mode</label>\n<select ng-model=\"dateMode\" class='form-control' ng-options=\"option.value as option.label for option in sourcesMode\"></select>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Minimum Date</label>\n<input type=\"text\"  ng-model=\"minimumDate\" datepicker class=\"datepicker form-control \" />\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Maximum Date</label>\n<input type=\"text\"  ng-model=\"maximumDate\" datepicker class=\"datepicker form-control \" />\n</div>\n\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
					
					$builder.registerComponent('currentLocation', {
						group : 'Misc',
						label : 'Current Location',
						hint : 'hint',
						required : false,
						minimumAccuracy : 100,
						enforceGPS : false,
						allowSubmissionIfNotAcquired : false,
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n<i class=\"fa fa-map-marker fa-4x\" validator-required=\"{{required}}\"/>\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<div class=\"form-group\">\n<label class='control-label'>Minimum Accuracy(m)</label>\n<input type=\"number\" min=\"100\" ng-model=\"minimumAccuracy\" class='form-control'/>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"enforceGPS\" /><span class=\"custom-checkbox\"></span>\nEnforce User to Enable GPS?\n</label>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"allowSubmissionIfNotAcquired\" /><span class=\"custom-checkbox\"></span>\nAllow Submission if The Required Accuracy is not Acquired after 10s? \n</label>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});

					$builder.registerComponent('photoAttachment', {
						group : 'Misc',
						label : 'Photo Attachment',
						hint : 'hint',
						required : false,
						numberOfPhoto : 1,
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n<i class=\"fa fa-camera fa-3x\" validator-required=\"{{required}}\"/>\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<div class=\"form-group\">\n<label class='control-label'>Number of Photos</label>\n<input type=\"number\" min=\"1\" max=\"3\" value=\"1\" ng-model=\"numberOfPhoto\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
					
					$builder.registerComponent('signaturePad', {
						group : 'Misc',
						label : 'Signature Pad',
						hint : 'hint',
						required : false,
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n</script><i class=\"fa fa-pencil-square-o fa-4x\" validator-required=\"{{required}}\"/>\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
					
					$builder.registerComponent('product', {
						group : 'Custom',
						label : 'Products',
						hint : 'hint',
						required : false,
						products : [],
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n</script><i class=\"fa fa-barcode fa-4x\" validator-required=\"{{required}}\"/>\n<span class='help-block'>{{products.length}} available products.</span>\n<span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
			    	
					$builder.registerComponent('promo', {
						group : 'Custom',
						label : 'Promotions',
						hint : 'hint',
						required : false,
						promotions : [],
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n</script><i class=\"fa fa-bullhorn fa-4x\" validator-required=\"{{required}}\"/>\n<span class='help-block'>{{promotions.length}} active promotions.</span>\n<span class='help-block'>{{hint}}</span>\n</div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
			    	
					$builder.registerComponent('event', {
						group : 'Custom',
						label : 'Events',
						hint : 'hint',
						required : false,
						events : [],
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n<div class=\"col-sm-8\">\n</script><i class=\"fa fa-music fa-4x\" validator-required=\"{{required}}\"/>\n<span class='help-block'>{{events.length}} ongoing events.</span>\n<span class='help-block'>{{hint}}</span>\n</div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
			    	
					
					$builder.registerComponent('installment', {
						group : 'Custom',
						label : 'Installment',
						hint : 'hint',
						required : false,
						installments : [],
						template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n<div class=\"col-sm-8\">\n</script><i class=\"fa fa-money fa-4x\" validator-required=\"{{required}}\"/>\n<span class='help-block'>{{hint}}</span>\n</div>\n</div>",
						popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n        <input type='text' ng-model=\"hint\" class='form-control'/>\n    </div>\n<div class=\"form-group\" \">\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
					});
			    	
					
					
					 
				} ]);
