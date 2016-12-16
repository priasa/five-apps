<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title>F I V E.</title>
	
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.css" >
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css" >
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" >
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pace.css">
		<link rel="icon"  type="image/ico" href="${pageContext.request.contextPath}/favicon.ico">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico">
		<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
	</head>
	<body class="gray-bg">
    	<div class="middle-box text-center animated fadeInDown">
            	<h1>FIVE.</h1>
            	<c:if test="${not empty param.error && not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION']}">
					<div class="alert alert-danger">
						<c:out value="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}" />
						
						<c:choose>
							<c:when test="${sessionScope['sub_status'] == 2}">
								<br/><br/>
								<a href="${pageContext.request.contextPath}/activation/resend/${sessionScope['sub_id']}/">
									Email to Me the Verification Link Again
								</a>
							</c:when>
							<c:when test="${sessionScope['sub_status'] == -1}">
								<br/><br/>
								<a href="${pageContext.request.contextPath}/forgotPassword">
									Reset Password
								</a>
							</c:when>
						</c:choose>
					</div>
				</c:if>
            	<form class="m-t" role="form" action="${ pageContext.request.contextPath }/web/submitlogin" method="POST">
	                <div class="form-group">
	                    <input type="text" class="form-control input-lg" name="j_username" placeholder="Username" required />
	                </div>
	                <div class="form-group">
	                    <input class="form-control input-lg" placeholder="Password" name="j_password" type="password" required />
	                </div>
	                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
	                <a href="${pageContext.request.contextPath}/" class="btn btn-default block full-width m-b">Home</a><br/>
	                
            	</form>
            	<p class="m-t"><small>@Copyright Smarta Sistem Indonesia 2016</small> </p>
        	</div>
    	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</body>
</html>
