$(document).ready(function ($) {
	"use strict";
	$('#shelf-content').perfectScrollbar({
		useBothWheelAxes: true,
		wheelPropagation: true,
		wheelSpeed: 30
	});
	
	$(".book a").popover({ container: "body", html: true})
});