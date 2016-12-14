$(function	()	{

	//Form Wizard 1
	var currentStep_1 = 1;
	
	//Form Wizard 2
	var currentStep_2 = 1; 
	
	$('.wizard-demo li a').click(function()	{
		
		return false;
	});
	 
	//Form Validation
	$('#basic-constraint').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				return false;
			}
        }
    }}); 
	
	$('#type-constraint').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				return false;
			}
        }
    }}); 
	 
	$('#formValidate1').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				alert('Registration Complete');
				return false;
			}
        }
    }}); 
	
	$('#formValidate2').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				alert('Your message has been sent');
				return false;
			}
        }
    }}); 
	 
	$('#formWizard1').parsley( { listeners: {
		onFieldValidate: function ( elem ) {
			// if field is not visible, do not apply Parsley validation!
			if ( !$( elem ).is( ':visible' ) ) {
				return true;
			}

			return false;
		},
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				
				currentStep_1++;
				
				if(currentStep_1 == 2)	{
					var hours = $("[name=departureTime]").val();
					if(hours.length == 0) {
						alert("Choose your departure time");
						currentStep_1 = 1;
						return false;
					}
					
					$('#displayHour').text(hours);
					
					$('#wizardDemo1 li:eq(1) a').tab('show');
					$('#wizardProgress').css("width","33%");
					
					$('#prevStep1').attr('disabled',false);
					$('#prevStep1').removeClass('disabled');
				}
				else if(currentStep_1 == 3) {
					var fullName = $("[name=fullName]").val();
					var title = $("[name=title]").val();
					var email = $("[name=email]").val();
					var phoneNumber = $("[name=phoneNumber]").val();
					var dateOfBirth = $("[name=dateOfBirth]").val();
					var idCard = $("[name=idCard]").val();
					
					$('[name=fullName]').text(title + " " + fullName);
					$('[name=email]').text(email);
					$('[name=phoneNumber]').text(phoneNumber);
					$('[name=dateOfBirth]').text(dateOfBirth);
					$('[name=idCard]').text(idCard);
					
					$('#wizardDemo1 li:eq(2) a').tab('show');
					$('#wizardProgress').css("width","33%");
					
					$('#prevStep1').attr('disabled',false);
					$('#prevStep1').removeClass('disabled');
					
				}
				else if(currentStep_1 == 4)	{
					var chairNumber = $("[name=seatNumber]").val();					
					if(chairNumber.length == 0) {
						alert("Please choose your seat");
						currentStep_1 = 3;
						return false;
					}
					
					$('#wizardDemo1 li:eq(3) a').tab('show');
					$('#wizardProgress').css("width","66%");
				}
				else if(currentStep_1 == 5)	{
					if(!$("[name=chk-terms]").is(':checked')) {
						alert("Please read and check the Terms first");
						currentStep_1 = 4; 
						return false;
					}
					
					var fullName = $("[name=fullName]").val();
					var title = $("[name=title]").val();
					var email = $("[name=email]").val();
					var phoneNumber = $("[name=phoneNumber]").val();
					var dateOfBirth = $("[name=dateOfBirth]").val();
					var idCard = $("[name=idCard]").val();
					var paymentMethod = $('input[name=paymentMethod]:checked', '#formWizard1').val();

					$('#fullName').text(title + " " + fullName);
					$('#email').text(email);
					$('#phoneNumber').text(phoneNumber);
					$('#dateOfBirth').text(dateOfBirth);
					$('#idCard').text(idCard);
					$('#paymentMethod').text(paymentMethod);
					
					$('#wizardDemo1 li:eq(4) a').tab('show');
					$('#wizardProgress').css("width","99%");
					
					$('#nextStep1').attr('disabled',true);
					$('#nextStep1').addClass('disabled');
					
					return true;
					$.isLoading({ text: "Loading" });
				}
				
				return false;
			}
        }
    }});
	
	$('#formWizard2').parsley( { listeners: {
		onFieldValidate: function ( elem ) {
			// if field is not visible, do not apply Parsley validation!
			if ( !$( elem ).is( ':visible' ) ) {
				return true;
			}

			return false;
		},
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
					
				currentStep_2++;
				
				if(currentStep_2 == 2)	{
					$('#wizardDemo2 li:eq(1) a').tab('show');
					
					$('#prevStep2').attr('disabled',false);
					$('#prevStep2').removeClass('disabled');
				}
				else if(currentStep_2 == 3)	{
					$('#wizardDemo2 li:eq(2) a').tab('show');
				}
				else if(currentStep_2 == 4)	{
					$('#wizardDemo2 li:eq(3) a').tab('show');
					
					$('#nextStep2').attr('disabled',true);
					$('#nextStep2').addClass('disabled');
				}
				
				return false;
			}
        }
    }});
	
	$('#prevStep1').click(function()	{
		
		currentStep_1--;
		
		if(currentStep_1 == 1)	{
		
			$('#wizardDemo1 li:eq(0) a').tab('show');
			$('#wizardProgress').css("width","66%");
				
			$('#prevStep1').attr('disabled',true);
			$('#prevStep1').addClass('disabled');
			
			$('#wizardProgress').css("width","33%");
		}
		else if(currentStep_1 == 2)	{
			$('#wizardDemo1 li:eq(1) a').tab('show');
		}
		else if(currentStep_1 == 3)	{
		
			$('#wizardDemo1 li:eq(2) a').tab('show');
			$('#wizardProgress').css("width","66%");
					
			$('#nextStep1').attr('disabled',false);
			$('#nextStep1').removeClass('disabled');
			
			$('#wizardProgress').css("width","66%");
		}
		
		return false;
	});
	
	$('#prevStep2').click(function()	{
		
		currentStep_2--;
		
		if(currentStep_2 == 1)	{
		
			$('#wizardDemo2 li:eq(0) a').tab('show');
				
			$('#prevStep2').attr('disabled',true);
			$('#prevStep2').addClass('disabled');
			
		}
		else if(currentStep_2 == 2)	{
			$('#wizardDemo2 li:eq(1) a').tab('show');
		}
		
		else if(currentStep_2 == 3)	{
		
			$('#wizardDemo2 li:eq(2) a').tab('show');
					
			$('#nextStep2').attr('disabled',false);
			$('#nextStep2').removeClass('disabled');
			
		}
		
		return false;
	});
});