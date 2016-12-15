<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title>Forgot Password</title>
	
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.css" >
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css" >
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" >
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pace.css">
		<link href="${pageContext.request.contextPath}/favicon.ico" rel="shortcut icon" >

		
	</head>
	<body class="gray-bg">
    	<div class="middle-box text-center loginscreen animated fadeInDown">
        	<div>
            	<div>
					<img class="animated flip" src="${pageContext.request.contextPath}/images/mtf2.jpg" />
				</div>
            	<h3>Welcome to Mobile Calculator</h3>
            	<br>
            	<h4>Forgot password.</h4>
            	<p class="text-muted text-center"><small>Enter your email address that you used to register. We'll send you an email with your username and a link to reset your password.</small></p>
            	<form:form class="m-t" role="form" commandName="forgotPasswordForm" action="${ pageContext.request.contextPath }/forgotpassword" method="POST">
	                <div class="form-group">
	                    <form:input path="email" class="form-control" type="email" placeholder="Email Address" required="true" />
	                </div>
	                <button type="submit" class="btn btn-danger block full-width m-b">Reset</button>
	                <a href="${pageContext.request.contextPath}/" class="btn btn-default block full-width m-b">Home</a><br/>
	                
				</form:form>
	            <a href="${pageContext.request.contextPath}/web/login"><small>Login in</small></a>
            	<p class="m-t"> <small>@Copyright Mandiri Tunas Finance 2015</small> </p>
        	</div>
    	</div>
    	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</body>
</html>