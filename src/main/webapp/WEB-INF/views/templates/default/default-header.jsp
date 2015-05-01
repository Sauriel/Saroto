<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<c:forEach var="carouselItem" items="${carousel}" varStatus="status">
		<li data-target="#carousel-example-generic" data-slide-to="${status.index}" ${status.first ? 'class="active"' : ''}></li>
		</c:forEach>
	</ol>
	
	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<c:forEach var="carouselItem" items="${carousel}" varStatus="status">
			<div class="item ${status.first ? 'active' : ''}">
				<a href="${carouselItem.link}">
					<img src="${imageFolder}${carouselItem.image}" alt="${carouselItem.titel}">
				</a>
				<div class="carousel-caption">
					<h3>${carouselItem.titel}</h3>
					<p>${carouselItem.text}</p>
				</div>
			</div>	
		</c:forEach>
	</div>
	
	<!-- Controls -->
	<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		 <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		 <span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		 <span class="sr-only">Next</span>
	</a>
</div>