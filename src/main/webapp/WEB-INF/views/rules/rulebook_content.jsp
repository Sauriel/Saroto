<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
 
<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="title">- ${site}</tiles:putAttribute>
	
	<tiles:putAttribute name="content">
		<h1>${rulebook}</h1>
	</tiles:putAttribute>
	
</tiles:insertDefinition>