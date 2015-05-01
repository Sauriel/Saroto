package de.sauriel.saroto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.sauriel.saroto.config.variables.RequestViewMapping;

@Controller
public class FaviconController {

	private final String FAVICON_FOLDER = "resources/images/favicon/";
	private final String DEFAULT_FAVICON = "d20_color.ico";

	@RequestMapping(RequestViewMapping.FAVICON)
	String showFavicon() {
		return "forward:/" + FAVICON_FOLDER + DEFAULT_FAVICON;
	}

}
