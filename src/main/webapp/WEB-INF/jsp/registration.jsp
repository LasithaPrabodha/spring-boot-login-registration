<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<jsp:include page="template/head.jsp">
	<jsp:param name="title" value="Registration" />
	<jsp:param name="contextPath" value="${contextPath}" />
</jsp:include>
<body>

	<div class="container">
		<div class="row justify-content-md-center mt-4">
			<div class="col col-lg-6">
				<form:form method="POST" modelAttribute="userForm"
					class="form-signin">
					<h2 class="form-signin-heading">Create your account</h2>
					<spring:bind path="username">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="username" class="form-control"
								placeholder="Username" autofocus="true"></form:input>
							<form:errors path="username"></form:errors>
						</div>
					</spring:bind>
					
					<spring:bind path="firstName">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="firstName" class="form-control"
								placeholder="First Name" autofocus="true"></form:input>
							<form:errors path="firstName"></form:errors>
						</div>
					</spring:bind>
					
					<spring:bind path="lastName">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="lastName" class="form-control"
								placeholder="Last Name" autofocus="true"></form:input>
							<form:errors path="lastName"></form:errors>
						</div>
					</spring:bind>
					
					<spring:bind path="email">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="email" class="form-control"
								placeholder="Email" autofocus="true"></form:input>
							<form:errors path="email"></form:errors>
						</div>
					</spring:bind>

					<spring:bind path="password">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="password" class="form-control"
								placeholder="Password"></form:input>
							<form:errors path="password"></form:errors>
						</div>
					</spring:bind>

					<spring:bind path="passwordConfirm">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="passwordConfirm"
								class="form-control" placeholder="Confirm your password"></form:input>
							<form:errors path="passwordConfirm"></form:errors>
						</div>
					</spring:bind>

					<button class="btn btn-lg btn-primary" type="submit">Submit</button>
					
					<a class="btn btn-lg btn-secondary"	href="${contextPath}/">Cancel</a>
				</form:form>
			</div>
		</div>
	</div>

	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>