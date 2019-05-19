<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<jsp:include page="template/head.jsp">
	<jsp:param name="title" value="Welcome" />
	<jsp:param name="contextPath" value="${contextPath}" />
</jsp:include>

<body>
	<div class="container mt-4">
		<div class="row justify-content-end">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>

				<h2>
					Welcome ${pageContext.request.userPrincipal.name} | <a
						href="${contextPath}/edit-profile">Edit Profile</a> | <a href="#"
						onclick="document.forms['logoutForm'].submit()">Logout</a>
				</h2>


			</c:if>
		</div>
	</div>

	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>