package de.sauriel.nexus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RulebookController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RulebookController.class);

	@RequestMapping(value = "/rules/", method = RequestMethod.GET)
	public String showRulebook(Model model, @RequestParam String rulebook) {
		LOGGER.info("Rulebook: {} ", rulebook);

		model.addAttribute("rulebook", rulebook);

		return "rules/rulebook_content";
	}

}
