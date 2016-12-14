(function() {
  angular.module('builder.components', ['builder', 'validator.rules']).config([
    '$builderProvider', function($builderProvider) {
    	$builderProvider.registerComponent('label', {
    		group : 'Basic',
    		label : 'Label',
    		hint : 'hint',
    		required : false,
    		textColor : '#000000',
    		autoLinkWebEmailAddress : false,
    		autoLinkPhoneNumber : false,
    		colorOptions : [
    				                  {label : 'Transparent',value : 'transparent'},
    				                  {label : 'Color',value : 'color'}
    				                  ],
    		colorOption : 'transparent',
    		color : 'transparent',
    		template: "<div class=\"form-group\">\n<label style=\"color:{{textColor}}; background-color:{{color}};\" for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n<span class='help-block'>{{hint}}</span>\n</div>\n</div>",
    		popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Text Color</label><br/><input type=\"color\" ng-model = \"textColor\" class=\"form-control\">\n</div>\n<div class=\"form-group\" \">\n<label class='control-label'>Background Color</label>\n<select ng-model=\"colorOption\" class='form-control' ng-options=\"option.value as option.label for option in colorOptions\"></select>\n</div>\n<div class=\"form-group\" ng-show=\"colorOption == 'color'\">\n<label class='control-label'>Color</label><br/><input type=\"color\" ng-model = \"color\" class=\"form-control\">\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Auto-Link</label>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"autoLinkWebEmailAddress\" /><span class=\"custom-checkbox\"></span>\nWeb & Email Address\n</label>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"autoLinkPhoneNumber\" /><span class=\"custom-checkbox\"></span>\nPhone Number\n</label>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>",
    	});
    	
    	$builderProvider.registerComponent('textField', {
			group : 'Basic',
			label : 'Text Field',
			hint : 'hint',
			required : false,
			autoCorrect : false,
			capitalizationOptions : [
			                  {label : 'none',value : 'none'},
			                  {label : 'capitalize the first letter of each word',value : 'capitalFirstLetterWord'},
			                  {label : 'capitalize the first letter of each sentence',value : 'capitalFirstLetterSentence'},
			                  {label : 'capitalize all characters',value : 'capitalAll'}
			                  ],
			capitalization : 'none',
			template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n        <input type=\"text\" ng-model=\"inputText\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\" id=\"{{formName+index}}\" class=\"form-control\" />\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
	        popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n<div class=\"form-group\" \">\n<label class='control-label'>Auto Capitalization</label>\n<select ng-model=\"capitalization\" class='form-control' ng-options=\"option.value as option.label for option in capitalizationOptions\"></select>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"autoCorrect\" /><span class=\"custom-checkbox\"></span>\nAuto Correct\n</label>\n</div>\n\n\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"		
		});
    	
    	$builderProvider.registerComponent('multilineTextfield', {
			group : 'Basic',
			label : 'Multiline Textfield',
			hint : 'hint',
			required : false,
			autoCorrect : false,
			capitalizationOptions : [
			                  {label : 'none',value : 'none'},
			                  {label : 'capitalize the first letter of each word',value : 'capitalFirstLetterWord'},
			                  {label : 'capitalize the first letter of each sentence',value : 'capitalFirstLetterSentence'},
			                  {label : 'capitalize all characters',value : 'capitalAll'}
			                  ],
			capitalization : 'none',
			lines : 5,
			template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n        <textarea type=\"text\" ng-model=\"inputText\" rows=\"{{lines}}\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\" id=\"{{formName+index}}\" class=\"form-control\" rows='6' />\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
			popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n<div class=\"form-group\" \">\n<label class='control-label'>Auto Capitalization</label>\n<select ng-model=\"capitalization\" class='form-control' ng-options=\"option.value as option.label for option in capitalizationOptions\"></select>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Lines</label>\n<input type='number' ng-model=\"lines\" min=\"5\" value=\"5\"  class='form-control'/>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"autoCorrect\" /><span class=\"custom-checkbox\"></span>\nAuto Correct\n</label>\n</div>\n\n\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"		
		});
    	$builderProvider.registerComponent('phoneNumber', {
			group : 'Basic',
			label : 'Phone Number',
			hint : 'hint',
			required : false,
			template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n        <input type=\"text\" ng-model=\"inputText\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\" id=\"{{formName+index}}\" class=\"form-control\" />\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
	        popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n\n\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"		
		});
    	$builderProvider.registerComponent('emailAddress', {
			group : 'Basic',
			label : 'Email Address',
			hint : 'hint',
			required : false,
			autoCorrect : false,
			template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n        <input type=\"text\" ng-model=\"inputText\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\" id=\"{{formName+index}}\" class=\"form-control\" />\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
	        popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n\n\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"		
		});
    	
    	$builderProvider.registerComponent('numericField', {
    		group : 'Basic',
    		label : 'Numeric Field',
    		hint : 'hint',
    		required : false,
    		negativeNumberAllowed : false,
    		allowDecimal : false,
    		template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n        <input type=\"text\" ng-model=\"inputText\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\" id=\"{{formName+index}}\" class=\"form-control\" />\n        <p class='help-block'>{{hint}}</p>\n    </div>\n</div>",
    		popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/></div>\n<div class=\"form-group\">\n<label class='control-label'>Hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"allowDecimal\" /><span class=\"custom-checkbox\"></span>\nAllow Decimal\n</label>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"negativeNumberAllowed\" /><span class=\"custom-checkbox\"></span>\nNegative Number Allowed\n</label>\n</div>\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"
    	});
    	
    	return $builderProvider.registerComponent('webAddress', {
			group : 'Basic',
			label : 'Web Address',
			hint : 'hint',
			required : false,
			autoCorrect : false,
			template: "<div class=\"form-group\">\n<label for=\"{{formName+index}}\" class=\"col-sm-4 control-label\" ng-class=\"{'fb-required':required}\">{{label}}</label>\n    <div class=\"col-sm-8\">\n<input type=\"text\" ng-model=\"inputText\" validator-required=\"{{required}}\" validator-group=\"{{formName}}\" id=\"{{formName+index}}\" class=\"form-control\" />\n        <span class='help-block'>{{hint}}</span>\n    </div>\n</div>",
	        popoverTemplate : "<form>\n<div class=\"form-group\">\n<label class='control-label'>Label</label>\n<input type='text' ng-model=\"label\" validator=\"[required]\" class='form-control'/>\n</div>\n<div class=\"form-group\">\n<label class='control-label'>hint</label>\n<input type='text' ng-model=\"hint\" class='form-control'/>\n</div>\n\n\n<div class=\"checkbox\">\n<label>\n<input type='checkbox' ng-model=\"required\" /><span class=\"custom-checkbox\"></span>\nRequired\n</label>\n</div>\n\n<hr/>\n<div class='form-group'>\n<input type='submit' ng-click=\"popover.save($event)\" class='btn btn-primary' value='Save'/>\n<input type='button' ng-click=\"popover.cancel($event)\" class='btn btn-default' value='Cancel'/>\n<input type='button' ng-click=\"popover.remove($event)\" class='btn btn-danger' value='Delete'/>\n</div>\n</form>"		
		});
    }
  ]);

}).call(this);
