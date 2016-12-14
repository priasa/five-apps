<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title>Change Password</title>
	
	    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
	
	    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/favicon.ico" rel="shortcut icon" >
	    
	</head>
	<body class="gray-bg">
    	<div class="middle-box text-center loginscreen animated fadeInDown">
        	<div>
            	<div>
					<img src="${pageContext.request.contextPath}/images/mtf2.jpg" />
				</div>
            	<h3>Welcome to Mobile Calculator</h3>
            	<br>
            	<h4>Reset password.</h4>
            	<form:form class="form-signin"  role="form" commandName="resetPasswordForm" action="${ pageContext.request.contextPath }/submitpassword" method="POST">
	                <form:hidden path="username"/>
	                <div class="form-group">
						<form:password path="password" class="form-control" placeholder="New Password" required="true" />
						<form:errors path="password" cssClass="help-block text-danger"/>
	                </div>
	                <div class="form-group">
	                    <form:password path="retypePassword" class="form-control" placeholder="Re-Type Password" required="true" />
						<form:errors path="retypePassword" cssClass="help-block text-danger"/>
	                </div>
	                <button type="submit" class="btn btn-danger block full-width m-b">Reset</button>
				</form:form><br><br>
            	<p class="m-t"> <small>@Copyright Mandiri Tunas Finance 2015</small> </p>
        	</div>
    	</div>
    	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</body>
</html>
