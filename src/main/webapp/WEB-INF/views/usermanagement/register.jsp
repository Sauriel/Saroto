<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1><spring:message code="navbar.register"/></h1>

<form:form method="POST" action="/register" accept-charset="UTF-8" modelAttribute="registerModel">
	<div>
		<label>
			<spring:message code="navbar.register.email"/>
			<form:input path="email"/>
		</label>
		<form:errors path="email" />
	</div>
	<div>
		<label>
			<spring:message code="navbar.register.password"/>
			<form:password path="password"/>
		</label>
		<form:errors path="password" />
	</div>
	<div>
		<label>
			<spring:message code="navbar.register.password.verify"/>
			<form:password path="passwordVerify"/>
		</label>
		<form:errors path="passwordVerify" />
	</div>
	
	<form:errors path="" />
	<br />
	
	<form:button type="submit">
		<spring:message code="navbar.register"/>
	</form:button>
</form:form>