<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<html>
	<head>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
		
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/sticky-footer-navbar.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/favicon.png" rel="shortcut icon" >

		<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/2.0.1/css/bootstrap-datetimepicker.min.css" rel="stylesheet"> -->
		<!--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/2.0.1/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.3/locales.min.js"></script> -->	
	</head>
	<body>
		<div class="navbar navbar-default navbar-fixed-top" role="navigation">
      		<div class="container">
		        <div class="navbar-header">
		        	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			            <span class="sr-only">Toggle navigation</span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
		          	</button>
		          	<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Smart Form</a>
		        </div>
		        <div class="navbar-collapse collapse">
		        	
		        </div>
      		</div>
    	</div>
    	<div class="container">
		</div>
    	<script type="text/javascript">
			$(document).ready(function(){
				$('.datepicker').datepicker({
					dateFormat: 'd/MM/yyyy'
				});
			});
		</script>