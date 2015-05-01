<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="rulesets-group" id="accordion">
	<div class="ruleset-default">
		<div class="ruleset-heading">
			<h4 class="ruleset-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
					<span class="glyphicon glyphicon-chevron-down"></span> <spring:message code="menu.rules.title"/>
				</a>
			</h4>
		</div>
		<div id="collapseOne" class="ruleset-collapse collapse">
			<div class="ruleset-body shelf">
				<div id="shelf-content" class="contentHolder">
					<div class="content-x">
						<c:forEach var="rulebook" items="${rulebooks}">
							<span class="book">
								<a href="/rules/?rulebook=${rulebook.link}" 
									data-trigger="hover" 
									data-content="${rulebook.description}" 
									data-placement="bottom" 
									title="${rulebook.title}">
										<img src="${imageFolder}ruleset/${rulebook.cover}">
								</a>
							</span>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>