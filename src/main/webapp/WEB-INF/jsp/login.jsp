<%@page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Log in with your account</title>

<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/css/common.css" rel="stylesheet"
	type="text/css" />
</head>

<body>

	<div class="container">
		<div class="row justify-content-md-center mt-4">
			<div class="col col-lg-6">
				<form method="POST" action="${contextPath}/login"
					class="form-signin">
					<h2 class="form-heading">Log in</h2>

					<div class="form-group ${error != null ? 'has-error' : ''}">
						<span>${message}</span> <input name="username" type="text"
							class="form-control" placeholder="Username" autofocus="true" />
						<input name="password" type="password" class="form-control"
							placeholder="Password" /> <span>${error}</span> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
					<div class="form-group">
						<button class="btn btn-lg btn-primary btn-block" type="submit">Log
							In</button>
						<h4 class="text-center">
							<a href="${contextPath}/registration">Create an account</a>
						</h4>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>