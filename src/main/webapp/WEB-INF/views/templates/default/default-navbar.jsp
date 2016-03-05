<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only"><spring:message code="navbar.navigation.toogle"/></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="http://sauriel.de"><img class="sauriel-icon" src="${imageFolder}logo/icon.png"> Sauriel.de</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<c:forEach var="navbarLink" items="${navbarLinks}">
					<li ${navbarLink.name eq site ? "class=active" : ""}><a href="${navbarLink.link}">${navbarLink.name}</a></li>
				</c:forEach>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/register/"><spring:message code="navbar.register"/></a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown"><spring:message code="navbar.login"/> <strong class="caret"></strong></a>
					<div class="dropdown-menu dropdown-form">
						<form:form method="POST" action="/login" accept-charset="UTF-8" modelAttribute="loginModel">
							<div class="form-group">
								<spring:message var="mail" code="navbar.login.mail"/>
								<form:input path="loginName" type="email" cssClass="form-control" placeholder="${mail}" name="email" required="required" />
							</div>
							<div class="form-group">
								<spring:message var="password" code="navbar.login.password"/>
								<form:password path="password" cssClass="form-control" placeholder="${password}" name="password" required="required" />
							</div>
							<div class="form-group">
								<label>
									<form:checkbox path="rememberMe" name="remember" /> <spring:message code="navbar.login.remember"/>
								</label>
							</div>
							<form:hidden path="view" value="${pageType}" />
							<form:button class="btn btn-default" type="submit" name="submit" >
								<spring:message code="navbar.login.submit"/>
							</form:button>
						</form:form>
					</div>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>