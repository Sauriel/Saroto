<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
 
<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="title">Home</tiles:putAttribute>
	<tiles:putAttribute name="content">

		<h1>Home-Content</h1>
		<p>The time on the server is ${serverTime}.</p>

	</tiles:putAttribute>
</tiles:insertDefinition>