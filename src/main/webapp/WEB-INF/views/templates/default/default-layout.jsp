<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="de">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta charset="utf-8">
		<title>Sauriel.de <tiles:insertAttribute name="title" ignore="true"/></title>
		
		<tiles:insertAttribute name="header-includes" />
	</head>
	<body>
		<tiles:insertAttribute name="navbar" />
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />
		<div class="row">
			<div class="col-md-2"></div>
				<div class="col-md-8" id="content">
					<tiles:insertAttribute name="content" />
				</div>
			<div class="col-md-2"></div>
		</div>
		<tiles:insertAttribute name="footer" />
		
		<tiles:insertAttribute name="footer-includes" />
	</body>
</html>